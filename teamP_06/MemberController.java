package teamP_06;



public class MemberController {
	MemberService mService = new MemberService();

	public Member findMember(Member m) {
		//d.addAttribute("정보 조회", mService.getMemberData(m));	

		return mService.getMemberData(m);
	}
	
	public String[] joinMember(String memID, String memPW, String mName, String mEmail, String mImage) {

		return mService.setmemberDTO(memID, memPW, mName, mEmail, mImage);
	}
}

/*
public Member getMemberData(Member m, Model d) {
d.addAttribute("정보 조회", mService.getMemberData(m));	

return mService.getMemberData(m);
}

public String setMemberData(String memID, String memPW, String mName, String mEmail, String mImage, Model d) {

String result;
if(mImage == null && mName == null) {
	//d.addAttribute("회원가입", mService.setmemberDTO(memID, memPW, mEmail));
	result=mService.setmemberDTO(memID, memPW, mEmail);
}
else if (mImage == null){
	//d.addAttribute("회원가입", mService.setmemberDTO(memID, memPW, mName, mEmail));	
	result=mService.setmemberDTO(memID, memPW, mName, mEmail);
}
else {
	//d.addAttribute("회원가입", mService.setmemberDTO(memID, memPW, mName, mEmail, mImage));
	result=mService.setmemberDTO(memID, memPW, mName, mEmail, mImage);
}

return result;
}
*/