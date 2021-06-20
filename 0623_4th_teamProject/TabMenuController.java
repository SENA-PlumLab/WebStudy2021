package javaexp.a00_exp.teamP_04;

import java.util.ArrayList;

public class TabMenuController {
	
	TabMenuService tmService = new TabMenuService();
	
	public int countOfTabValue1(ShopProfile sp, Model d) {
		return tmService.productListTab(sp).size();
	}
	public int countOfTabValue2(ShopProfile sp, Model d) {
		return tmService.shopInboundTab(sp).size();
	}
	public int countOfTabValue3(ShopProfile sp, Model d) {
		return tmService.bookmarkProductTab(sp).size();
	}
	public int countOfTabValue4(ShopProfile sp, Model d) {
		return tmService.shopReviewTab(sp).size();
	}
	public int countOfTabValue5(ShopProfile sp, Model d) {
		return tmService.followingTab(sp).size();
	}
	public int countOfTabValue6(ShopProfile sp, Model d) {
		return tmService.followerTab(sp).size();
	}
	
	
	
	public String productListTab(ShopProfile sp, Model d) {
		d.addAttribute("상품 탭", tmService.productListTab(sp));	
		ArrayList<Product> pdList = tmService.productListTab(sp);
		System.out.println("--------------------");
		for(int i=pdList.size()-1; i>=0; i--) {
			System.out.println((pdList.size()-i)+".");
			System.out.println("이미지: "+pdList.get(i).getImageURL());
			System.out.println("상품 이름: "+pdList.get(i).getName());
			System.out.println("가격: "+pdList.get(i).getPrice());
			System.out.println("업로드 "+pdList.get(i).getCountOfUploadedDay()+"일째");
			System.out.println("지역: "+pdList.get(i).getRegion());
			if(pdList.get(i).isSoldout()) {System.out.println("** 판매 완료! **");}
			System.out.println("--------------------");
		}
		return "호출화면";
	}
	
	public String shopInboundTab(ShopProfile sp, Model d) {
		d.addAttribute("상점문의 탭", tmService.shopInboundTab(sp));	
		ArrayList<Comment> inboundList = tmService.shopInboundTab(sp);
		int cnt=1;
		System.out.println("--------------------");
		for(int i=0; i<inboundList.size(); i++) {
			if(inboundList.get(i).getPriority()==0) {
				System.out.println(cnt + ".");
				System.out.println("보낸사람:" + inboundList.get(i).getFromMember().getShopImageURL() + ", "
						+ inboundList.get(i).getFromMember().getShopName());
				System.out.println("문의내용: " + inboundList.get(i).getComment() + "   ("
						+ inboundList.get(i).getCountOfUploadedDay() + "일 전)");
				System.out.println("--------------------");
				cnt++;
			}
			else { //대댓글 출력
				System.out.print(new String("     ").repeat(inboundList.get(i).getPriority()));
				System.out.println("reply");
				System.out.print(new String("     ").repeat(inboundList.get(i).getPriority()));
				System.out.println("보낸사람:" + inboundList.get(i).getFromMember().getShopImageURL() + ", "
						+ inboundList.get(i).getFromMember().getShopName());
				System.out.print(new String("     ").repeat(inboundList.get(i).getPriority()));
				System.out.println("문의내용: " + inboundList.get(i).getComment() + "   ("
						+ inboundList.get(i).getCountOfUploadedDay() + "일 전)");
				System.out.println("--------------------");
			}
		}
		return "호출화면";
	}
	
	public ArrayList<Comment> callShopInbound(ShopProfile sp, Model d){
		d.addAttribute("상점문의 리스트", tmService.shopInboundTab(sp));
		
		return tmService.shopInboundTab(sp);
	}
	
	public String shopInboundReply(ShopProfile sp, ArrayList<Comment> inboundList, int index, String comment, Model d) {
		d.addAttribute("상점문의 댓글달기", tmService.shopInboundReply(sp, inboundList, index, comment));	
		return "호출화면";
	}
	
	public String bookmarkProductTab(ShopProfile sp, Model d) {
		d.addAttribute("찜 탭", tmService.bookmarkProductTab(sp));	
		ArrayList<Product> bookmarkPdList = tmService.bookmarkProductTab(sp);
		System.out.println("--------------------");
		for(int i=bookmarkPdList.size()-1; i>=0; i--) {
			System.out.println((bookmarkPdList.size()-i)+".");
			System.out.println("이미지: "+bookmarkPdList.get(i).getImageURL());
			System.out.println("상품 이름: "+bookmarkPdList.get(i).getName());
			System.out.println("가격: "+bookmarkPdList.get(i).getPrice());
			System.out.println("업로드 "+bookmarkPdList.get(i).getCountOfUploadedDay()+"일째");
			System.out.println("지역: "+bookmarkPdList.get(i).getRegion());
			System.out.println("--------------------");
		}
		return "호출화면";
	}

	public String shopReviewTab(ShopProfile sp, Model d){
		d.addAttribute("상점후기 탭", tmService.shopReviewTab(sp));
		ArrayList<ShopReview> rvList = tmService.shopReviewTab(sp);
		System.out.println("--------------------");
		for(int i=rvList.size()-1; i>=0; i--) {
			System.out.println((rvList.size()-i)+".");
			System.out.println("상점 이미지: "+rvList.get(i).getReviewer().getShopImageURL());
			System.out.println("상품 이름: "+rvList.get(i).getReviewer().getShopName());
			System.out.println(" - 상품 이미지: "+rvList.get(i).getProduct().getImageURL());
			System.out.println(" - 상품 이름: "+rvList.get(i).getProduct().getName());
			System.out.println("리뷰: "+rvList.get(i).getComment()+"   ("+rvList.get(i).getCountOfUploadedDay()+"일 전)");
			System.out.print("별점: ");
			for(int j=0; j<rvList.get(i).getStarRate(); j++) {
				System.out.print("★");
			}
			for(int j=rvList.get(i).getStarRate(); j<5; j++) {
				System.out.print("☆");
			}
			System.out.println("\n--------------------");
		}
	return "호출화면";
	}
	
	public String followerTab(ShopProfile sp, Model d) {
		d.addAttribute("팔로워 탭", tmService.followerTab(sp));
		ArrayList<ShopProfile> followerList = tmService.followerTab(sp);
		System.out.println("--------------------");
		for(ShopProfile p:followerList) {
			System.out.println("상점 이름: "+p.getShopName());
			System.out.println("상점 이미지: "+p.getShopImageURL());
			System.out.println("상품: "+p.getCountSell()); //임의의 값
			System.out.println("팔로워: "+p.getCountVisit()%10); //임의의 값
			for(int j=0; j<p.getStarRate(); j++) {
				System.out.print("★");
			}
			for(int j=p.getStarRate(); j<5; j++) {
				System.out.print("☆");
			}
			System.out.println();
			System.out.println("--------------------");
		}
		return "호출화면";
	}
	
	public String followingTab(ShopProfile sp, Model d) {
		d.addAttribute("팔로잉 탭", tmService.followingTab(sp));
		ArrayList<ShopProfile> followingList = tmService.followingTab(sp);
		System.out.println("--------------------");
		for(ShopProfile p:followingList) {
			System.out.println("상점 이름: "+p.getShopName());
			System.out.println("상점 이미지: "+p.getShopImageURL());
			System.out.println("상품: "+p.getCountSell());
			System.out.println("팔로워: "+p.getCountVisit()%10);
			for(int j=0; j<p.getStarRate(); j++) {
				System.out.print("★");
			}
			for(int j=p.getStarRate(); j<5; j++) {
				System.out.print("☆");
			}
			System.out.println("\n--------------------");
		}
	return "호출화면";
	}
}
