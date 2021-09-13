package teamP_09;

public class Member {
	private String memnum;
	private int gb;
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String tel;
	private String mail;
	private String joinDate;
	private String editDate;
	
	public Member() {
		
	}
	public Member(String memnum, int gb, String id, String pw, String name, String birth, String tel, String mail, String joinDate,
			String editDate) {
		super();
		this.memnum = memnum;
		this.gb = gb;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.tel = tel;
		this.mail = mail;
		this.joinDate = joinDate;
		this.editDate = editDate;
	}


	public String getMemnum() {
		return memnum;
	}


	public int getGb() {
		return gb;
	}


	public String getId() {
		return id;
	}


	public String getPw() {
		return pw;
	}


	public String getBirth() {
		return birth;
	}


	public String getTel() {
		return tel;
	}


	public String getMail() {
		return mail;
	}


	public String getJoinDate() {
		return joinDate;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEditDate() {
		return editDate;
	}


	public void setMemnum(String memnum) {
		this.memnum = memnum;
	}


	public void setGb(int gb) {
		this.gb = gb;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}


	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	
	
}
