package javaexp.a00_exp.teamP_03;

public class UpdateinfoDao {
	
public String[] callMemberInfo(MemberProfile mp) {
		
		//회원정보 DB에 접근해서 받아온 데이터를 아래와 같이 가정함.
		String[] memberInfo = new String[5];
		memberInfo[0] = mp.getName(); //회원 이름
		memberInfo[1] = mp.getPhone(); // 휴대폰번호
		memberInfo[2] = mp.getPccc(); // 통관번호
		memberInfo[3] = mp.getEmail(); // 이메일
		memberInfo[4] = mp.isAbleToGetInform(); // 
		
		return memberInfo;	
	}
	
	public String editPhone(MemberProfile mp, String phone) {
		//DB의 값을 변경하고 저장함!!
		mp.setPhone(phone);
		return "휴대폰번호 수정 성공";
	}
	public String editPccc(MemberProfile mp, String pccc) {
		//DB의 값을 변경하고 저장함!!
		mp.setPccc(pccc);
		return "통관번호 수정 성공";
	}
	public String editEmail(MemberProfile mp, String email) {
		//DB의 값을 변경하고 저장함!!
		mp.setEmail(email);
		return "이메일주소 수정 성공";
	}
	public String editAble(MemberProfile mp, String able){
		//DB의 값을 변경하고 저장함!!
		return "정보수정 성공";
	}
}
