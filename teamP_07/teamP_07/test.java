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

		// 2(크리에이터)로 등업
		String[] mm = { "mem-1022", "mem-1005" };
		//System.out.println(mDao.updateToCreator(mm));
		
		System.out.println(mDao.updatePortfolioConfirm(mm));
		

		// 포트폴리오 대기중인 회원 조회
		ArrayList<Member> mList2 = mDao.getmemberDTO_gradeCheck();
		for (Member m : mList2) {
			System.out.println(m.getmID() + ", " + m.getpfTitle());
		}
		
		
		ReportDao rDao = new ReportDao();
		ArrayList<Report> rList=rDao.getReportDTO();
		for(Report r: rList) {
			System.out.println(r.getRptNum()+", "+r.getCttnum()+", "+r.getMemNum2());
		}
		
		String[] rpt = { "rpt-0005", "mem-0006" };
		String[] mm = { "mem-1022", "mem-1005" };
		
		rDao.updateReport("eee-0005", rpt, 1);
		rDao.updateMemberReport(mm);
		
		LogDao lDao = new LogDao();
		
		ArrayList<Log> plist = lDao.getLogDTO_ctt();
		ArrayList<Log> plist2 = lDao.getLogDTO_member();	
		
		for(Log l : plist) {
			System.out.println(l.getLogNum()+", "+l.getMemo());
		}
		for(Log l : plist2) {
			System.out.println(l.getLogNum()+", "+l.getMemo());
		}
		*/
		
		AdminDao aDao = new AdminDao();
		Admin a = aDao.getAdminDTO_byID("himan");
		Admin a3 = aDao.getAdminDTO_byID("himan6");
		Admin a2 = aDao.getAdminDTO_byPK("eee-0006");
		
		System.out.println(a.getId()+", "+a.getPass());
		System.out.println(a2.getId()+", "+a2.getPass());
		System.out.println(a3.getId()+", "+a3.getPass());
		
		System.out.print(a.getEeeNum());
	}

}
