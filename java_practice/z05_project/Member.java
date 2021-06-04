package javaexp.z05_project;

public class Member {
	private String id, pass, name, email, auth, point;

	public Member(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}

	public Member(String id, String pass, String name, String email, String auth, String point) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.auth = auth;
		this.point = point;
	}

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}