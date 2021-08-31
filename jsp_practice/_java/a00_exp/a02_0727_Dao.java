package a00_exp;

public class a02_0727_Dao {
	
	
	public a02_0727 verify(String id, String pw) {
		
		//'select * from member where id=? and pass=?'
		//boolean veri = (id=="himan" && pw=="7777");
		boolean veri1 = (id.equals("himan") && pw.equals("7777"));
		
		
		if(veri1) { return new a02_0727(id, pw);}
		
		return new a02_0727("로그인 실패", null);
		
	}
	
}
