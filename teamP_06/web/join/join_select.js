var email_holder2 = document.getElementById("email-holder2");
var email2Select = document.getElementsByName('mEmail2_select');
var email2 = document.getElementById("mEmail2");

email2.style.display = "none";
//선택 옵션
function getEmailSelect(e){
	var value = e.value;
	if(value === "Other"){
		mEmail2_show();
	}
	else{
		mEmail2_hide();
		email2.value = value;
	}
}
//보이기
function mEmail2_show() {
	email2.value = "";
	email2.style.display = "block";
}
//숨기기
function mEmail2_hide() {
	email2.style.display = "none";
}
