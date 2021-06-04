package javaexp.a05_object;

public class A04_AccessModifier {

/*

#접근제어자
1. 자바의 모든 구성요소는 적절한 접근 제어자에 의해서 데이터를 할당할 수 있어야
	객체가 정상적인 작동이 가능하다.
2. 객체간의 비정상적인 데이터 할당으로 메모리나 동작에 오류가 발생할 수 있다.
3. 자바에서의 접근제어자 종류, 범위
	1) private: 외부 객체에서 직접적인 접근을 하지 못하게 하는 것. 내부에서만 사용 가능
	2) (default): 상단에 선언한 동일한 패키지 내에서만 접근하여 사용하는 것
					ex) package javaexp.a05_object;
	3) protected: 상속 관계에 있으면, 패키지가 다르더라도 접근 가능하게 함.
	4) public: 패키지가 다르더라도 해당 구성 요소에 접근이 가능하게 함.


 */
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Z01_Person p01 = new Z01_Person();
		
		//System.out.println(p01.name); //private는 외부 클래스에서 호출해서 사용할 수 없다.
		System.out.println(p01.address); // 서로 동일한 package에 있기 때문에 사용 가능.
		System.out.println(p01.inherit); // 상속관계 없지만 같은 패키지 이므로 접근 가능.
		System.out.println(p01.announce); //public 믿고있었다구~~
		
		
	}

}
