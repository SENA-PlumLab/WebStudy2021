package teamP_06;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		MemberController mCon = new MemberController();
		Member m = new Member("mem-0039");
		
		//--------------------------
		m = mCon.findMember(m);
		
		System.out.println(m.getMemNum()+"\n");
		System.out.println(m.getmID()+"\n");
		System.out.println(m.getmPW()+"\n");
		System.out.println(m.getmName()+"\n");
		System.out.println(m.getmEmail()+"\n");
		System.out.println(m.getmImage()+"\n");
		System.out.println(m.getJoinDate()+"\n");
		System.out.println(m.getmPoint()+"\n");
		
		//--------------
		
		System.out.println(mCon.joinMember("java11", "java1", "자바의정석1", "java11@naver.com", "image!"));
		System.out.println(mCon.joinMember("java22", "java2", "자바의정석2", "java22@naver.com", null));
		System.out.println(mCon.joinMember("java33", "java3", null, "java33@naver.com", null));
		*/
		
		
		//MemberDao mDao = new MemberDao();
		MemberController mCon  = new MemberController();
		/*
		System.out.println(mDao.updateImage("mem-0039", "**Image Updated!!"));
		System.out.println(mDao.updatemName("mem-0039", "닉네임변경!"));
		*/
		
		int rand = (int) (Math.random() * 100 + 1);
		//System.out.println(mDao.setmemberDTO("ID"+rand, "pass", rand+"@a.com"));
		//System.out.println(mCon.joinMember("ID"+rand, "pass", "닉네임", rand+"@a.com", "이미지"));
		System.out.println(mCon.joinMember("ID"+rand, "pass", "냥", rand+"@a.com", null));
	}

}
