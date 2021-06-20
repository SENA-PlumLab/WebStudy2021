package javaexp.a00_exp.teamP_04;

import java.util.ArrayList;

public class TabMenuDao {
	
	ArrayList<Comment> inboundList = new ArrayList<Comment>();
	ArrayList<Product> pdList = new ArrayList<Product>();
	ArrayList<Product> bookmarkPdList = new ArrayList<Product>();
	ArrayList<ShopReview> rvList = new ArrayList<ShopReview>();
	ArrayList<ShopProfile> followingList = new ArrayList<ShopProfile>();
	ArrayList<ShopProfile> followerList = new ArrayList<ShopProfile>();
	
	public TabMenuDao(){
		ShopProfile comment1 = new ShopProfile("M0001212", "왕바보", "농담곰이 좋아요", 230, 20, 8, 8, true);
		inboundList.add(new Comment("M0002154", comment1, "님 농담곰 인형은 없나요", 8, 0));
		inboundList.add(new Comment("M0002154", comment1, "님님 잠만보 인형은 있어요???", 3, 0));
	
		pdList.add(new Product("M0002154", "P0101524", "images/product_1524.jpg", "커피머신", 50000, 80, "서울시 양천구"));
		pdList.add(new Product("M0002154", "P0101851", "images/product_1851.jpg", "모니터", 80000, 62, "서울시 양천구"));
		pdList.add(new Product("M0002154", "P0102345", "images/product_2345.jpg", "인형4개", 8000, 15, "서울시 양천구"));
		pdList.add(new Product("M0002154", "P0103720", "images/product_3720.jpg", "텀블러", 12000, 10, "서울시 양천구"));
		pdList.add(new Product("M0002154", "P0104520", "images/product_4520.jpg", "젤네일 스티커", 3000, 5, "서울시 양천구"));
		pdList.get(0).setSoldout(true);
		pdList.get(1).setSoldout(true);
		pdList.get(2).setSoldout(true);
		
		
		bookmarkPdList.add(new Product("M0001484", "P0103756", "images/product_3756.jpg", "2G 휴대폰", 50000, 10, "서울시 송파구"));
		bookmarkPdList.add(new Product("M0002388", "P0104888", "images/product_4888.jpg", "2DS 본체+놀동숲", 60000, 3, "경기 부천시"));
		bookmarkPdList.add(new Product("M0002751", "P0104554", "images/product_4554.jpg", "어쿠스틱 기타", 40000, 5, "서울 강남구"));
		
		ShopProfile review1 = new ShopProfile("M0000606", "동그리동동", "동그라미가..좋다!", 606, 825, 450, 402, true);
		ShopProfile review2 = new ShopProfile("M0001122", "별과음악", "눈동자에 Cheers...★", 1122, 600, 212, 150, true);
		ShopProfile review3 = new ShopProfile("M0000323", "막걸리에파전", "파전 바삭바삭", 323, 126, 30, 30, true);
		review1.setShopImage("images/profile_M0000606.jpg");
		review2.setShopImage("images/profile_M0001122.jpg");
		review3.setShopImage("images/profile_M0000323.jpg");
		rvList.add(new ShopReview(review1, "M0002154", "잘 받았어요^^", pdList.get(0), 70, 3));
		rvList.add(new ShopReview(review2, "M0002154", "잘쓰겠읍니다.. 건강하세요,,~! ", pdList.get(1), 45, 4));
		rvList.add(new ShopReview(review3, "M0002154", "귀 엽 다 . . . !", pdList.get(2), 13, 5));
		
		ShopProfile following1 = new ShopProfile("M0001589", "왕싸게팔음", "마참내! 드디어! 왕 싸다!", 186, 230, 82, 78, true);
		ShopProfile following2 = new ShopProfile("M0001522", "훠궈먹자", "일주일에 4번 훠궈 먹는 사람", 122, 522, 128, 115, true);
		following1.setShopImage("images/profile_M0001589.jpg");
		following1.setStarRate(3);
		following2.setShopImage("images/profile_M0001522.jpg");
		followingList.add(following1);
		followingList.add(following2);
		
		followerList.add(review1);
		followerList.add(review2);
		followerList.add(review3);
		
	}
	
	
	public ArrayList<Product> callProductInfo(ShopProfile sp) {
		return pdList;
	}
	
	public ArrayList<Comment> callShopInbound(ShopProfile sp) {
		return inboundList;
	}
	public ArrayList<Comment> editShopInbound(ShopProfile sp, ArrayList<Comment> inboundList, int index, String comment){
		int cntZero=0;
		int cntElse=0;
		for(int i=0; i<inboundList.size(); i++){
			if(inboundList.get(i).getPriority()==0) {	
				cntZero++;
				if(cntZero>index) { cntZero--; break;}
			}
			else {	cntElse++;}
		}
		int dynamicIndex=cntZero+cntElse;
		inboundList.add(dynamicIndex, new Comment(inboundList.get(dynamicIndex-1).getFromMember().getMemberNum(), 
													sp, comment, 0, inboundList.get(dynamicIndex-1).getPriority()+1));
		//dynamicIndex-1 ==> 하나의 문의에 댓글이 이미 1개이상 있을 경우.... dynamicIndex-1으로는 원문에 대한 댓글을 달 수 없음 ㅠㅠ
		return inboundList;
	}
	
	public ArrayList<Product> callBookmarkProductInfo(ShopProfile sp) {
		return bookmarkPdList;
	}
	
	public ArrayList<ShopReview> callShopReview(ShopProfile sp){
		return rvList;
	}
	
	public ArrayList<ShopProfile> callFollowing(ShopProfile sp){
		return followingList;
	}
	
	public ArrayList<ShopProfile> callFollower(ShopProfile sp){
		return followerList;
	}
	
}