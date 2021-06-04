package javaexp.a08_api;



/*

# 상수를 열거형으로 사용할 때 효과적으로 쓰이는 데이터 유형 enum (열거형 상수)

1. 선언
	public enum 변수명{상수1, 상수2, 상수3, ...}
2. 속성, 메소드
	.values() : 배열로 상수 전체를 가져온다.
	.name() : 이름
	.ordinal() : enum의 포함되어있는 순서 index값

 */


public class A08_Enum {
	
	public enum Colors{RED, BLACK, YELLOW, BLUE}
	
	public enum Flowers{ROSE, DANDELION, ACASIA}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Colors color = Colors.BLACK;
		System.out.println(color);
		Colors[] cs = Colors.values();
		// for(단위객체: 배열형데이터)  끝날 때 까지 데이터를 뽑아냄 //for each 구문 
		for(Colors x:cs) {
			System.out.println(x.name()+"\t"+x.ordinal());
		}
		//System.out.println(color.name());
		
		Flowers[] fl1 = Flowers.values();
		for(Flowers x : fl1) {
			System.out.println(x.name()+"\t"+x.ordinal());
		}
		
		
		
		
		
	}

}
