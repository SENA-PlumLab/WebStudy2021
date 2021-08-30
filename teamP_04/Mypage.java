package javaexp.a00_exp.teamP_04;

import java.util.Scanner;

public class Mypage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MypageController myCon = new MypageController();
		TabMenuController tmCon = new TabMenuController();
		
		//DB 기본값 임의로 설정
		ShopProfile sp = new ShopProfile("M0002154", 
								"상점이름1", "상점 소개를 입력하세요.",
								125, 20, 5, 5, true);
		sp.setShopImage("images/profile_M0002154.jpg");							
		
		Model m = new Model();
		Scanner sc1 = new Scanner(System.in);
		String menuSelect;
		String selectYN;
		while(true) {
			System.out.println("******** 메뉴 선택 *******");
			System.out.println("1.상품 탭 \t 2.상점문의 탭 \t 3.찜 탭");
			System.out.println("4.상점후기 탭 \t 5.팔로잉 탭 \t 6.팔로워 탭");
			System.out.println("10. 회원정보 표시 \t 11. 상점이름 수정 \t 12. 상점 이미지 수정 ");
			System.out.println("13. 상점 소개 수정 \t 0. 종료");
			System.out.println("------------------------------");
			System.out.print("** 메뉴 선택: ");
			menuSelect = sc1.nextLine();
			System.out.println("*****************************\n");
			switch(menuSelect) {
				case "1":
				case "상품":
				case "상품 탭":
					System.out.println("========상품 탭 ("+tmCon.countOfTabValue1(sp, m)+")========");
					tmCon.productListTab(sp, m);
					System.out.println("============================\n");
					break;
				case "2":
				case "상점문의":
				case "상점문의 탭":
					System.out.println("========상점문의 탭 ("+tmCon.countOfTabValue2(sp, m)+")========");
					tmCon.shopInboundTab(sp, m);
					System.out.print("** 문의에 답변하시겠습니까?(Y/N): ");
					selectYN=sc1.nextLine();
					if(selectYN.equals("Y")) {
						int index;
						String comment;
						System.out.print("답변할 댓글 번호: ");
						index = sc1.nextInt();
						System.out.print("답변 내용: ");
						comment = sc1.nextLine();
						comment = sc1.nextLine();
						tmCon.shopInboundReply(sp, tmCon.callShopInbound(sp, m), index, comment, m);
						System.out.println("** 답변완료!");
					}
					System.out.println("============================\n");
					break;
				case "3":
				case "찜":
				case "찜 탭":
					System.out.println("========찜 탭 ("+tmCon.countOfTabValue3(sp, m)+")========");
					tmCon.bookmarkProductTab(sp, m);
					System.out.println("============================\n");
					break;
				case "4":
				case "상점후기":
				case "상점후기 탭":;
					System.out.println("========상점후기 탭 ("+tmCon.countOfTabValue4(sp, m)+")========");
					tmCon.shopReviewTab(sp, m);
					System.out.println("============================\n");
					break;
				case "5":
				case "팔로잉":	
				case "팔로잉 탭":	
					System.out.println("========팔로잉 탭 ("+tmCon.countOfTabValue5(sp, m)+")========");
					tmCon.followingTab(sp, m);
					System.out.println("============================\n");
					break;
				case "6":
				case "팔로워":
				case "팔로워 탭":
					System.out.println("========팔로워 탭 ("+tmCon.countOfTabValue6(sp, m)+")========");
					tmCon.followerTab(sp, m);
					System.out.println("============================\n");
					break;
					
				case "10":
				case "회원정보":
				case "회원정보 표시":
					System.out.println("========회원정보 요약표시========");
					myCon.showSummary(sp, m);
					System.out.println("============================\n");
					break;
				case "11":
				case "상점이름":
				case "상점이름 수정":
					System.out.println("========상점이름 수정========");
					System.out.print("**새 상점이름 입력: ");
					String newName=sc1.nextLine();
					myCon.editShopName(sp, newName, m);
					System.out.println("============================\n");
					break;
				case "12":
				case "상점 이미지":
				case "상점 이미지 수정":
					System.out.println("========상점 이미지 수정========");
					System.out.print("**새 상점 이미지 URL 입력: ");
					String newImageURL = sc1.nextLine();
					myCon.editShopImageURL(sp, newImageURL, m);
					System.out.println("============================\n");
					break;
				case "13":
				case "상점 소개":
				case "상점 소개 수정":
					System.out.println("========상점 소개 수정========");
					System.out.print("**새 상점 소개 입력: ");
					String newShopIntro = sc1.nextLine();
					myCon.editShopIntro(sp, newShopIntro, m);
					System.out.println("============================\n");
					break;
				case "0":
				case "종료":
					break;
				default:
					System.out.println(" 제대로 된 값을 입력하세요! ");
					break;
			}
			if(menuSelect.equals("0")||menuSelect.equals("종료")) {break;}
		}
		
		System.out.println("============ 종료 !! =============\n");
		
		sc1.close();
	}

}
