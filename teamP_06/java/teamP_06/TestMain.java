package teamP_06;

import java.util.ArrayList;

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
	
		String id = mCon.findIdByEmail("4564@google.com");
		String pass = mCon.findPwById("4564@google.com", id);
		System.out.println("Email로 ID찾기: 4564@google.com -->"+id);
		System.out.println("ID로 비번찾기:  "+pass);
		
		System.out.println("로그인 결과: "+mCon.logInMember(id, pass));
		*/
		
		BBSController bCon = new BBSController();
		
		/*
		BBS b = bCon.getBBS("bbs-0001");
		System.out.println(b.getTitle()+", "+b.getmName()+"("+b.getMemNum()+"), "+b.getHit());
		System.out.println(b.getContents()+"\n");
		
		b=bCon.visitBBS("bbs-0004");
		System.out.println("게시글 조회했습니다~! \n<"+b.getTitle()+"> \n(조회수: "+b.getHit()+")");
		
		
		BBSDao bDao = new BBSDao();
		
		ArrayList<String> restNumList= new ArrayList<String>();
		restNumList.add("ret-0004");
		restNumList.add("ret-0005");
		
		ArrayList<String> genList = new ArrayList<String>();
		genList = bCon.writeBBS("mem-0002", "제목!", "부제목!", "본문!", restNumList);

		System.out.println(genList.get(0)+" 글 작성 완료!");
		
		
		
		ArrayList<BBSRec> rcList = new ArrayList<BBSRec>();
		
		rcList = bCon.getBBSRecByBBSNum(genList.get(0));
		for (int i=0; i<rcList.size(); i++) {
			System.out.println(rcList.get(i).getRestNum()+"\n");
			System.out.println(rcList.get(i).getRestTitle()+"\n");
			System.out.println(rcList.get(i).getRestAddress()+"\n");
		}
		
		
		System.out.println(bCon.deleteBBS("bbs-0006"));


String bbsNum = "bbs-0006";

BBS b = bCon.visitBBS(bbsNum);

System.out.println(b.getAvailable()+"\n");
System.out.println(b.getBbsDate()+"\n");
System.out.println(b.getBbsNum()+"\n");
System.out.println(b.getContents()+"\n");
System.out.println(b.getHit()+"\n");

if(b.getAvailable() == 0) {
	System.out.println("is Zero!");
}


		BBSDao bDao = new BBSDao();
		int numOfElement = 8;
		int page = 2;
		ArrayList<BBS> bbsList = bDao.getBBSbyIndex(numOfElement, page);
		System.out.println((numOfElement*(page-1))+1);
		System.out.println(numOfElement*page);
		for(int i=0; i<bbsList.size(); i++) {
			System.out.println(bbsList.get(i).getBbsNum()+"\n");
		}
		System.out.println(bbsList.size());
		//로딩된 리스트가 8개보다 작을 때(8-bbsList.size() > 0)
		if(bbsList.size()<8){
			for(int i=bbsList.size(); i<8; i++){
				//memNum=0으로 된 익명객체 생성해서 넣어둠.
				bbsList.add(new BBS());
				bbsList.get(i).setBBSEmpty();
			}
		}
		*/
		
		
		
		System.out.println(bCon.getCountOfBBS());
	}
}
