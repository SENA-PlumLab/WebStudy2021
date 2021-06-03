package javaexp.a00_exp.teamP_03;

public class UpdateinfoService {

	UpdateinfoDao upDao = new UpdateinfoDao();

	public String[] showMemberInfo(MemberProfile mp) {
		// 회원정보 DB에 접근해서 받아온 데이터를 아래와 같이 가정함.
		String[] memberInfo = upDao.callMemberInfo(mp);

		return memberInfo;
	}

	public String editPhone(MemberProfile mp, String phone) {
		if (phone.equals("") || phone.equals(null)) {
			return "정보수정 없음";
		}
		upDao.editPhone(mp, phone);
		return "휴대폰번호 수정 성공";
	}

	public String editPccc(MemberProfile mp, String pccc) {
		if (pccc.equals("") || pccc.equals(null)) {
			return "정보수정 없음";
		}
		upDao.editPccc(mp, pccc);
		return "통관번호 수정 성공";
	}

	public String editEmail(MemberProfile mp, String email) {
		if (email.equals("") || email.equals(null)) {
			return "정보수정 없음";
		}
		upDao.editEmail(mp, email);
		return "이메일주소 수정 성공";
	}

	public String editAble(MemberProfile mp, String able) {
		if (able.equals("true") || able.equals("false")) {
			upDao.editAble(mp, able);
			return "정보제공동의 수정 성공";
		}
		return "정보수정 없음";
	}
}
