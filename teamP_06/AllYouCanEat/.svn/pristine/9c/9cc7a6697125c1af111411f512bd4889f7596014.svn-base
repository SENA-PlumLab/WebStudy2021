function checkForm_signUp() {
    
	//입력여부, 길이, 형식 검사
	var memID = document.getElementById("s-memID");
	var memPW = document.getElementById("s-memPW");
	
	//입력여부, 일치여부 검사
	var memPW2 = document.getElementById("memPW2");
	
	//입력여부 검사
	var mEmail1 = document.getElementById("mEmail1");
	var mEmail2 = document.getElementById("mEmail2");
	
	//길이 검사
	var mName = document.getElementById("mName");
	
	var re = /^[a-zA-Z][0-9a-zA-Z]{1,14}$/;
	// 아이디가 적합한지 검사할 정규식
	var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    // 이메일이 적합한지 검사할 정규식
	
    // 입력 유무 체크
    if(memID.value == '') {
        window.alert("Enter ID");
        memID.focus();
        memID.select();
        return false; // 아이디 입력이 안되어 있다면 submint 이벤트를 중지
    }
	// **아이디 형식 체크
	else if(!re.test(memID.value) || !(memID.value.length >= 4 && memID.value.length <= 12)){
		alert("ID는 영어로 시작하는 4~15글자입니다. (영어+숫자 조합) ");
		return false;
    }

    else if(memPW.value == ''){
        alert('암호를 입력하세요.'); 
        memPW.focus();
      	memPW.select();
        return false;
    }
	else if(memPW2.value == ''){
        alert('암호 확인을 입력하세요.');
        memPW2.focus();
        memPW2.select();
        return false;
    }
	// **암호 재확인 체크
	else if(memPW.value != memPW2.value){
        alert('암호 확인이 정확하지 않습니다.'); 
        memPW2.focus();
      	memPW2.select();
        return false;
    }
	else if(mEmail1.value == ''){
        alert('이메일을 입력하세요.');
        mEmail1.focus();
        mEmail1.select();
        return false;
    }
	else if(mEmail2.value == ''){
        alert('이메일 도메인을 입력하세요.');
        mEmail2.focus();
        mEmail2.select();
        return false;
    }
	// **이메일 형식 테크
	else if(!re2.test(mEmail1.value+'@'+mEmail2.value) ) {
        alert("적합하지 않은 이메일 형식입니다.");
		return false;
    }
	else if((mName.value != '') && getByteB(mName.value)>25){
		alert("닉네임은 최대 25byte 사용 가능합니다.");
		return false;
    }
	
	
	
	function getByteB(str) {
		var byte = 0;
		for (var i = 0; i < str.length; ++i) {
			// 기본 한글 3바이트 처리
			(str.charCodeAt(i) > 127) ? byte += 3 : byte++;
		}
		return byte;

	}

}

function checkForm_logIn() {
    
	//입력여부, 길이, 형식 검사
	var memID = document.getElementById("l-memID");
	var memPW = document.getElementById("l-memPW");
	
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
	else if(!re.test(memID.value) || !(memID.value.length >= 4 && memID.value.length <= 12)){
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

