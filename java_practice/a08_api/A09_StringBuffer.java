package javaexp.a08_api;


/*

# String BUffer

1. 문자열은 추가적으로 +=로 처리할 시, 해당 문자열의 같은 ㅔㅁ모리에서 데이터를 추가하는 것이 아니라,
	계속 새로운 heap 영역의 메모리를 만들어가기 떄문에, 메모리 관리가 비효율적
	
2. 문자열에 대한 하나의 메모리에 효과적인 추가처리를 위해서
	1)	StringBuffer
		heap 메모리를 사용하여 메모리 관리를 효율적으로 처리
	2) 주요 기능 메소드
		.append("마지막에 추가할 문자열")
		.insert(특정 위치 index, "추가할 문자열)
		.delete(시작index, 마지막index): 해당 위치 데이터 삭제
		.replace(위치index, 위치index, "대체 문자열")

 */



public class A09_StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String name = "홍호홍";
		// +=는 새로운 heap메모리를 할당한다.
		name+=", 김기김";
		
		StringBuffer sbf = new StringBuffer("안녕하세요!");
		sbf.append(" 좋은 하루 입니다~");
		sbf.insert(6, "!문자열 삽입!");
		System.out.println(sbf.toString());
		sbf.delete(13, 19);
		sbf.replace(0, 6, "^^(변경처리)");
		System.out.println(sbf.toString());
		
		
		StringBuffer sbf2 = new StringBuffer("# 과일목록입니다 #\n");
		System.out.println(sbf2.toString());
		sbf2.append("사과\n바나나\n딸기\n");
		sbf2.delete(15, 19);//바나나 삭제
		System.out.println(sbf2.toString());
		sbf2.replace(15, 18, "오렌지");
		System.out.println(sbf2.toString());
	}

}
