package teamP_09;

import com.google.gson.Gson;

public class MemberService {
	
	private MemberDao dao;
	private Gson gson;
	
	public MemberService() {
		dao = new MemberDao();
		gson = new Gson();
	}
	
	public Member getMember(String id) {
		Member m = dao.getMember_byID(id);
		if(m.getMemnum()==null) {
			m.setMemnum("0");
		}
		return m;
	}
	
	public String getJsonMember(String id) {
		String memJson="{}";
		Member mem = dao.getMember_byID(id);
		if(mem!=null) {
			memJson = gson.toJson(mem);
		}
		return memJson;
	}
}
