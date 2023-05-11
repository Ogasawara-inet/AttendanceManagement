/**
 * 
 */

// 「月次報告を印刷する」から呼び出される関数
function printReport(){
	
	// 非表示にする要素を取得
	var header = document.getElementById("header"); // ヘッダー
	var message = document.getElementById("message"); // 表示メッセージ
	var info = document.getElementById("info"); // メッセージとボタンのエリア
	var reportStatus = document.getElementById("reportStatus"); // 「月次報告：～～～」
	var errorMessage = document.getElementById("errorMessage"); // 祝日のファイルが取得できなかった場合のエラー
	
	// 印刷しない要素を非表示
	header.style.display = "none";
	if(message != null) message.style.display = "none"; // 存在しないときもあるのでnullチェック
	info.style.display = "none";
	reportStatus.style.display = "none";
	if(errorMessage != null) errorMessage.style.display = "none";
	
	// 印刷
	window.print();
	
	// 非表示にした要素を元に戻す
	header.style.display = "block";
	if(message != null) message.style.display = "block"; // 存在しないときもあるのでnullチェック
	info.style.display = "block";
	reportStatus.style.display = "block";
	if (errorMessage!= null) errorMessage.style.display = "block";
	 
}
