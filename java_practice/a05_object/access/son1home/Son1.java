package javaexp.a05_object.access.son1home;

import javaexp.a05_object.access.woodcutterhome.WoodCutter;

public class Son1 extends WoodCutter{
	
	public void callData() {
		
		//상속관계에 있는 외부 패키지 클래스
		
		// 1.private 접근 불가
		//System.out.println(hiddenCloth);
		
		// 2.default 같은 패키지에서만 가능
		//System.out.println(savingMoney);
		
		// 3.protected 외부패키지여도 상속관계 있으면 접근 가능
		System.out.println(inheritMoney);
		
		// 4.public 어떤 패키지에서도 접근 가능
		System.out.println(weddingDate);
	}
}
