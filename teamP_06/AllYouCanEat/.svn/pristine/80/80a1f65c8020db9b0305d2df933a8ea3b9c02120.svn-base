package Project_6th.JAVA.z0717_project;

import java.util.Scanner;

public class delListView {
	delListController delCon = new delListController();
	
	public static void main(String[] args) {

		delListController delCon = new delListController();
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("# 맛집 리스트 선택 #");
		System.out.println("1. 서울 맛집 TOP 10");
		System.out.println("2. 부산 맛집 TOP 10");
		System.out.println("3. 내가올린 리뷰 삭제하기");
		String delListSelect = sc.nextLine();
		if(delListSelect.equals("1")) {
			delCon.delListView();
			
			String restSelect = sc.nextLine();
			if(restSelect.equals("1")) {
				
				
			}else if(restSelect.equals("2")){
				System.out.println("======가게정보======");
				delCon.restView();
				System.out.println("# 리뷰 #");
				delCon.reviewView();

				System.out.println("# 리뷰를 작성하시겠습니까?(Y/N)#");
				String reviewPost = sc.nextLine();
				if(reviewPost.equals("Y")||reviewPost.equals("y")) {
					System.out.println("별점을 선택해주세요 (1~5)");
					String reviewPoint = sc.nextLine(); 
					System.out.println("리뷰내용을 입력해주세요");
					String reviewContent = sc.nextLine();
					System.out.println("사진을 업로드하시겠습니까?(자동)");
					String reviewPhoto = "../image/burgerparkreivew.jpg";
					delCon.insertReview(new review("", "", "", Integer.parseInt(reviewPoint), null, reviewContent, reviewPhoto));
					System.out.println("===== 리뷰 ======");
					delCon.reviewView();
					
				}else if (reviewPost.equals("N")||reviewPost.equals("n")) {
					
				}else {
					System.out.println("해당메뉴가 없습니다.");
				}
			}else if(restSelect.equals("3")){
				
			}else if(restSelect.equals("4")){
				
			}else if(restSelect.equals("5")) {
				
			}else{
				System.out.println("해당번호는 없습니다.");
			}
			
		}else if(delListSelect.equals("2")) {
			
			System.out.println("아직 개발중");
			
		}else if(delListSelect.equals("3")) {
			
			System.out.println("삭제하고자 하는 리뷰를 선택하세요. rev-0006");
			String del = sc.nextLine();
			delCon.deleteReview(del);
			
		}else {
			System.out.println("해당메뉴가 없습니다.");
		}

	}
}
