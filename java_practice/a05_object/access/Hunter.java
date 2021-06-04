package javaexp.a05_object.access;

import javaexp.a05_object.access.friendship.WoodCutter;

public class Hunter {



	
	
	void callData() {
		WoodCutter wc = new WoodCutter();
		//(default) 같은 패키지 아니므로 접근 불가
		//System.out.println(wc.hiddenDeer);
		
		//private 접근 불가
		//System.out.println(wc.hiddenCloth);
	}
}
