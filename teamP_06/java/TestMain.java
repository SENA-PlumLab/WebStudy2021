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
		//System.out.println(mCon.joinMember("ID"+rand, "pass", "냥", rand+"@a.com", null));
	
	/*
		if(mCon.verifyMember("테스트", "테스")) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	*/
		String id = mCon.findIdByEmail("4564@google.com");
		String pass = mCon.findPwById("4564@google.com", id);
		System.out.println("Email로 ID찾기: 4564@google.com -->"+id);
		System.out.println("ID로 비번찾기:  "+pass);
		
		System.out.println("로그인 결과: "+mCon.logInMember(id, pass));
	}

}
