function checkForm_findID() {
    
	//입력여부, 길이, 형식 검사
	var email = document.getElementById("find1-email");

	var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    // 이메일이 적합한지 검사할 정규식
    
    // 입력 유무 체크
    if(email.value == '') {
        window.alert("Enter email");
        email.focus();
        email.select();
        return false;
    }
	// **이메일 형식 테크
	else if(!re2.test(email.value) ) {
        alert("적합하지 않은 이메일 형식입니다.");
		return false;
    }

}
function checkForm_findPW() {
    
	//입력여부, 길이, 형식 검사
	var email = document.getElementById("find2-email");
	var id = document.getElementById("find2-id");
	
	var re = /^[a-zA-Z][0-9a-zA-Z]{1,14}$/;
	// 아이디가 적합한지 검사할 정규식
	var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    // 이메일이 적합한지 검사할 정규식
    
    
    if(email.value == '') {
        window.alert("Enter email");
        email.focus();
        email.select();
        return false; 
    }
    // **이메일 형식 테크
	else if(!re2.test(email.value) ) {
        alert("적합하지 않은 이메일 형식입니다.");
		return false;
    }
    // 입력 유무 체크
    else if(id.value == '') {
        window.alert("Enter ID");
        id.focus();
        id.select();
        return false; 
    }
	// **아이디 형식 체크
	else if(!re.test(id.value) || !(id.value.length >= 4 && id.value.length <= 12)){
		alert("ID는 영어로 시작하는 4~15글자입니다. (영어+숫자 조합) ");
		return false;
    }


}