package teamP_06;



public class MemberController {
	MemberService mService = new MemberService();
	
	public Member findMemberByMemNum(String memNum) {
		//d.addAttribute("정보 조회", mService.getMemberData(m));	

		return mService.getMemberDataByMemNum(memNum);
	}
	
	public Member findMemberByEmail(String email) {
		//d.addAttribute("정보 조회", mService.getMemberData(m));	

		return mService.getMemberDataByEmail(email);
	}
	
	public Member findMemberByID(String id) {
		//d.addAttribute("정보 조회", mService.getMemberData(m));	

		return mService.getMemberDataByID(id);
	}
	
	public String findIdByEmail(String email) {
		Member m = mService.getMemberDataByEmail(email);
		
		if(m.getMemNum()!=null) {
			return m.getmID();
		}
		
		return null;
		
	}
	
	public String findPwById(String email, String id) {
		Member m = mService.getMemberDataByID(email, id);
		
		if(m.getMemNum()!=null) {
			return m.getmPW();
		}
		
		return null;
	}
	
	public boolean logInMember(String id, String pass) {
		Member m = mService.getMemberDataByID(id);
		if(m.getMemNum()==null) {
			return false;
		}
		else if( id.equals(m.getmID()) && pass.equals(m.getmPW()) ) {
			
			return true;
		}
		return false;
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