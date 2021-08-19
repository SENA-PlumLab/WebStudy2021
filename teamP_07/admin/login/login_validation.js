function checkForm() {
    
	//입력여부, 길이, 형식 검사
	var memID = document.getElementById("id");
	var memPW = document.getElementById("pass");
	
	var re = /^[a-zA-Z][0-9a-zA-Z]{1,14}$/;
	// 아이디가 적합한지 검사할 정규식
	
    // 입력 유무 체크
    if(memID.value == '') {
        window.alert("Enter ID");
        memID.focus();
        memID.select();
        return false; // 아이디 입력이 안되어 있다면 submint 이벤트를 중지
    }
	// **아이디 형식 체크
	else if(!re.test(memID.value) || 
			!(memID.value.length >= 4 && memID.value.length <= 12)){
		alert("ID는 영어로 시작하는 4~15글자입니다. (영어+숫자 조합) ");
		return false;
    }

    else if(memPW.value == ''){
        alert('암호를 입력하세요.'); 
        memPW.focus();
      	memPW.select();
        return false;
    }
	
}

