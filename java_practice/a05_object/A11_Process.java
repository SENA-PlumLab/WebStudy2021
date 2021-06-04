package javaexp.a05_object;

public class A11_Process {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProcessExp p1 = new ProcessExp();
		
		p1.loop(1, 5);
		p1.loop(4, 8);
		p1.contDown(6, 2);
		p1.bonusCal(15000);
	}

}


class ProcessExp {
	
	// 반복문의 시작값과 끝값을 매개변수로 넣고, 반복문을 처리한다.
	
	void loop(int start, int end) {
		System.out.println("반복처리 === 시작:"+start+", 끝:"+end);
		for(int cnt=start; cnt<=end; cnt++) {
			System.out.println(cnt+"\t");
		}
		System.out.println();
	}
	
	void contDown(int start, int end) {
		System.out.println("== 카운트 다운 시작 ==  (시작:"+start+", 끝:"+end+")");
		for(int cnt=start; cnt>=end; cnt--) {
			System.out.println(cnt);
		}
		System.out.println("끝!");
	}
	
	void bonusCal(int input) {
		System.out.println("기본급: "+input+"원");
		System.out.println("보너스(30%): "+(int)(input*0.3)+"원");
		System.out.println("합계: "+(int)(input*1.3)+"원");
	}
	
}