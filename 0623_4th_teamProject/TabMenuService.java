package javaexp.a00_exp.teamP_04;

import java.util.ArrayList;

public class TabMenuService {
	
	TabMenuDao tmDao = new TabMenuDao();
	
	
	public ArrayList<Product> productListTab(ShopProfile sp) {
		ArrayList<Product> pdList = tmDao.callProductInfo(sp);
		return pdList;
	}
	
	public ArrayList<Comment> shopInboundTab(ShopProfile sp) {
		ArrayList<Comment> inboundList = tmDao.callShopInbound(sp);
		return inboundList;
	}
	
	public ArrayList<Comment> shopInboundReply(ShopProfile sp, ArrayList<Comment> inboundList, int index, String comment){
		tmDao.editShopInbound(sp, inboundList,index,comment);
		return inboundList;
	}

	public ArrayList<Product> bookmarkProductTab(ShopProfile sp) {
		ArrayList<Product> bookmarkPdList = tmDao.callBookmarkProductInfo(sp);
		return bookmarkPdList;
	}
	
	public ArrayList<ShopReview> shopReviewTab(ShopProfile sp){
		ArrayList<ShopReview> rvList = tmDao.callShopReview(sp);
		return rvList;
	}
	
	public ArrayList<ShopProfile> followingTab(ShopProfile sp){
		ArrayList<ShopProfile> followingList = tmDao.callFollowing(sp);
		return followingList;
	}
	
	public ArrayList<ShopProfile> followerTab(ShopProfile sp){
		ArrayList<ShopProfile> followerList = tmDao.callFollower(sp);
		return followerList;
	}
}
