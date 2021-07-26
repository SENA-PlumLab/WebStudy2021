package teamP_06;

public class MemberService {
	MemberDao mDao = new MemberDao();

	public Member getMemberData(Member m) {

		return mDao.getmemberDTO(m);
	}
	
	
	public String[] setmemberDTO(String memID, String memPW, String mName, String mEmail, String mImage) {
		String[] generated;
		generated=mDao.setmemberDTO(memID, memPW, mEmail);

		if(mName!=null) {
			mDao.updatemName(generated[0], mName);
		}
		
		if(mImage!=null) {
			mDao.updatemImage(generated[0], mImage);
		}

		return generated;
	}
	

}
