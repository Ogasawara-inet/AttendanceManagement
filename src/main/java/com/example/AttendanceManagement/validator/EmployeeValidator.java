package com.example.AttendanceManagement.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.AttendanceManagement.entity.Employee;
import com.example.AttendanceManagement.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmployeeValidator implements Validator{

	private final EmployeeRepository employeeRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {

		return Employee.class.isAssignableFrom(clazz);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Long id = ((Employee)target).getId();
		String empId = ((Employee)target).getEmpId();
		
		// 社員IDが未入力の場合はエラー
		if(empId == null || empId.isBlank()) {
			errors.rejectValue("empId", "empId_input_error", 
					"社員IDが未入力です");
			return;
		}
		
		// その社員IDを持つ社員がすでに登録されている場合はエラー
		// ただしそれが編集中のものと同一（IDが同一）の場合を除く
		Optional<Employee> empOpt = employeeRepository.findByEmpId(empId);
		
		if(empOpt.isPresent() && empOpt.get().getId() != id) {
			errors.rejectValue("empId", "registered_empId", 
					"その社員IDはすでに使用されています");
			return;
		}
		
	}

}
