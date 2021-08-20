$(".check").click(function(){ 
	var checkBtn = $(this);
	//checkBtn.parent() : checkBtn의 부모는 <td>이다.
	// checkBtn.parent().parent() : <td>의 부모이므로 <tr>이다.
	var tr = checkBtn.parent().parent();
	var td = tr.children();
	td.eq(1).append("<input type='hidden' value='"+td.eq(1).text()+"' name='pfNum'>");
});

//멤버 조회 팝업
function popUp_mem(e, memNum){
    window.open('visit_member.jsp?memNum='+memNum, '내용 확인', 'width=600px,height=600px,scrollbars=yes');
}
//콘텐츠 내용 조회 팝업
function popUp(e, pfNum){
    window.open('visit_contents.jsp?pfNum='+pfNum, '내용 확인', 'width=600px,height=600px,scrollbars=yes');
}

