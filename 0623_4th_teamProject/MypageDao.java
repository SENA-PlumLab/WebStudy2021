package javaexp.a00_exp.teamP_04;

public class MypageDao {

	public ShopProfile callMemberInfo(ShopProfile sp) {
		return sp;
	}
	public String editShopName(ShopProfile sp, String str) {
		// DB의 값을 변경하고 저장함!!
		sp.setShopName(str);
		return "변경 성공!";
	}
	public String editShopImageURL(ShopProfile sp, String str) {
		// DB의 값을 변경하고 저장함!!
		sp.setShopImage(str);
		return "변경 성공!";
	}
	public String editShopIntro(ShopProfile sp, String str) {
		// DB의 값을 변경하고 저장함!!
		sp.setShopIntro(str);
		return "변경 성공!";
	}
}
