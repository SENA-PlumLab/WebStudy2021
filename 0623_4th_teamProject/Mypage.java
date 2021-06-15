package javaexp.a00_exp.teamP_04;

public class Mypage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MypageController myCon = new MypageController();
		
		//DB 기본값 임의로 설정
		ShopProfile sp = new ShopProfile("M0002154", 
								"상점이름1", "상점 소개를 입력하세요.",
								120, 20, 5, 5, true);
		sp.setShopImage("c:\\\\profile_M0002154.jpg");							
		
		Model m = new Model();
	
		System.out.println("========회원정보 요약표시========");
		myCon.showSummary(sp, m);
		System.out.println("============================\n");
		System.out.println("========상점이름 수정========");
		myCon.editShopName(sp, m);
		System.out.println("============================\n");
		System.out.println("========상점 이미지 수정========");
		myCon.editShopImageURL(sp, m);
		System.out.println("============================\n");
		System.out.println("========상점 소개 수정========");
		myCon.editShopIntro(sp, m);
		System.out.println("============================\n");
		System.out.println("========회원정보 요약표시(updated!)========");
		myCon.showSummary(sp, m);
		System.out.println("============================\n");
	}

}
