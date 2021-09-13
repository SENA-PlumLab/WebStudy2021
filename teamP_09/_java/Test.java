package teamP_09;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MemberDao dao = new MemberDao();
		MemberService service = new MemberService();
		//Member m = dao.getMember_byID("himan");
		Member m = service.getMember("himan");
		System.out.println(m.getJoinDate());
	}

}
