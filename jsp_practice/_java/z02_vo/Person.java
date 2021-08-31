package z02_vo;

public class Person {
	String name;
	int age;
	String loc;
	
	public Person() {
		super();
	}
	
	
	public Person(String name, int age, String loc) {
		super();
		this.name = name;
		this.age = age;
		this.loc = loc;
	}


	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	public String getLoc() {
		return loc;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
	
}
