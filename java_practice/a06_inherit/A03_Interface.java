package javaexp.a06_inherit;


/*

#인터페이스 상속

1. 인터페이스는 상위에 기능 메소드와 추상 메소드를 통해서, 하위의 여러가지 기능을 효과적으로 처리할 때 사용된다.
2. 기본 형식
	interface 인터페이스명 {
		void call();
	}
	 --> 인터페이스는 기본적으로 public abstract 가 포함되어 있기 때문에 생략할 수 있다.
	하위클래스명 implements 인터페이스명{
		상위에 선언된 추상메소드 오버라이딩
		void call() { 재정의; }
	}
3. 기타 인터페이스의 속성 
	1) 인터페이스의 필드는 static 상수만 사용한다.
	2) default 메소드가 있다.
	3) static 메소드를 선언할 수 있다.


 */


public class A03_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Flyway f1 = new CountryFlying();
		f1.flying();
		Flyway f2 = new WorldFlying();
		f2.flying();
		System.out.println("----------------------------------");
		SoundWay s1 = new DuckSound();
		SoundWay s2 = new BabySound();
		SoundWay s3 = new RobotSound();
		s1.sound();
		s2.sound();
		s3.sound();
		System.out.println("----------------------------------");
		
		
		Mz mz1 = new Mz();
		// 클래스에 인터페이스 매개변수가 있으면.
		// 그 인터페이스를 상속받는 하위클래스들 모두 할당 가능하다.
		// setFly(Flyway fly)
		mz1.setFly(new CountryFlying());
		mz1.flying();
		mz1.setFly(f2);
		mz1.flying();
		mz1.setFly(null);
		mz1.flying();
		// 이후, 인터페이스 Flyway를 상송받는 그 어떤 클래스가 새로 정의되더라도.
		// Mz 클래스 자체에는 수정이 필요하지 않다.
		System.out.println("----------------------------------");
		
		// 인퍼테이스를 사용하면 추가적이거나 변경된 기능을 메인 객체인 Mz에 굳이 반영하지 않아도 처리가 가능해진다.
		mz1.setFly(new SpaceFlying());
		mz1.flying();
		
		SoundBox sb1 = new SoundBox();
		sb1.sound();
		sb1.setSound(s1);
		sb1.sound();
		
		System.out.println("----------------------------------");
		mz1.attack();
		mz1.setAtk(new LaserBeam());
		mz1.attack();
		mz1.setAtk(new RocketMissile());
		mz1.attack();
		
		
	}

}

interface SoundWay {
	void sound();
}

class DuckSound implements SoundWay{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("오리 소리가 난다.. 꽥");
	}
}
class BabySound implements SoundWay{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("응애");
	}
}
class RobotSound implements SoundWay{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("덜그럭...덜그럭..");
	}
}

class SoundBox {
	private SoundWay soundway;
	
	public void setSound(SoundWay soundway) {
		this.soundway = soundway;
	}
	
	public void sound() {
		if (soundway != null) {
			soundway.sound();
		} else {
			System.out.println("소리가 할당되지 않음.");
		}
	}
}



//----------------
interface Flyway {
	void flying();
}

class CountryFlying implements Flyway{
	@Override
	public void flying() {
		// TODO Auto-generated method stub
		System.out.println("우리 동네 날아가용");
	}
}

class WorldFlying implements Flyway{
	@Override
	public void flying() {
		// TODO Auto-generated method stub
		System.out.println("세계를 날아용");
	}
}

class SpaceFlying implements Flyway{
	@Override
	public void flying() {
		System.out.println("우주를 날아요!");
	}
}

interface AttackWay {
	void attack();
}

class LaserBeam implements AttackWay{
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("레이저빔입니다.");
	}
}
class RocketMissile implements AttackWay{
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("로켓미사일입니다.");
	}
}


class Mz{
	private Flyway fly;
	private AttackWay atk;

	public void setFly(Flyway fly) {
		this.fly = fly;
	}
	public void setAtk(AttackWay atk) {
		this.atk = atk;
	}
	
	public void flying() {
		System.out.println("로봇이..");
		if(fly!=null) {
			fly.flying();
		}else {
			System.out.println("날개가..없어요..");
		}
	}
	
	public void attack() {
		if(atk != null) {
			System.out.println("!! mz의 공격 !!");
			atk.attack();
		} else {
			System.out.println("공격 방법 선택 필요.");
		}
	}
}




