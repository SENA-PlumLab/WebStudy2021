package teamP_07;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberDao mDao = new MemberDao();
/*
		// 전체 회원 조회
		ArrayList<Member> mList = mDao.getmemberDTO();
		for (Member m : mList) {
			System.out.println(m.getmID() + ": " + m.getMemgrade() + ", " + m.getJoinDate());
		}
*/
		// 2(크리에이터)로 등업
		String[] mm = { "mem-1022", "mem-1005" };
		//System.out.println(mDao.updateToCreator(mm));
		
		System.out.println(mDao.updatePortfolioConfirm(mm));
		
		/*
		// 포트폴리오 대기중인 회원 조회
		ArrayList<Member> mList2 = mDao.getmemberDTO_gradeCheck();
		for (Member m : mList2) {
			System.out.println(m.getmID() + ", " + m.getpfTitle());
		}
		*/
	}

}
