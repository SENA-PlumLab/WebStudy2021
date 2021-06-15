package javaexp.a00_exp.teamP_04;

import java.util.Scanner;

public class MypageController {
	MypageService myService = new MypageService();
	//회원정보 요약
	public String showSummary(ShopProfile sp, Model d) {
		d.addAttribute("회원정보 요약", myService.summaryInfo(sp));	

		String[] sumInfo = myService.summaryInfo(sp);
		System.out.println("--------------------");
		System.out.println("상점 이름: "+sumInfo[1]+" (본인인증: "+sumInfo[8]+")");
		System.out.println("프로필사진: "+sumInfo[2]);
		System.out.println("상점 소개: "+sumInfo[3]);
		System.out.println("상점오픈일 "+sumInfo[4]+"일전, 상점 방문수 "+sumInfo[5]+"명, 상품판매 "
												+sumInfo[6]+"회, 택배발송 "+sumInfo[7]+"회");
		System.out.println("--------------------");
		return "회원정보 요약 출력";
	}
	
	public String editShopName(ShopProfile sp, Model d) {
		d.addAttribute("회원정보 요약", myService.summaryInfo(sp));	

		//임의로 출력하면...
		System.out.println("--------------------");
		Scanner sc1 = new Scanner(System.in);
		System.out.print("**새 상점이름 입력: ");
		myService.editShopName(sp, sc1.nextLine());
		System.out.println("상점이름 변경 완료!");
		System.out.println("--------------------");

		return "호출화면";
	}
	
	public String editShopImageURL(ShopProfile sp, Model d) {
		d.addAttribute("회원정보 요약", myService.summaryInfo(sp));	

		//임의로 출력하면...
		System.out.println("--------------------");
		Scanner sc1 = new Scanner(System.in);
		System.out.print("**새 상점 이미지 URL 입력: ");
		myService.editShopImageURL(sp, sc1.nextLine());
		System.out.println("상점 이미지 변경 완료!");
		System.out.println("--------------------");

		return "호출화면";
	}
	
	public String editShopIntro(ShopProfile sp, Model d) {
		d.addAttribute("회원정보 요약", myService.summaryInfo(sp));	

		//임의로 출력하면...
		System.out.println("--------------------");
		Scanner sc1 = new Scanner(System.in);
		System.out.print("**새 상점 소개 입력: ");
		myService.editShopIntro(sp, sc1.nextLine());
		System.out.println("상점 소개 변경 완료!");
		System.out.println("--------------------");

		return "호출화면";
	}
}

