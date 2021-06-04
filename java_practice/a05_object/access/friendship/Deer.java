package javaexp.a05_object.access.friendship;

public class Deer {

		void callData() {
			WoodCutter wc = new WoodCutter();
			//(default) 같은 패키지에 있으므로 접근 가능.
			System.out.println(wc.hiddenDeer);
			
			//private 같은 패키지여도 접근 불가
			//System.out.println(wc.hiddenCloth);
		}

}
