package javaexp.a00_exp.teamP_04;

public class MypageService {

	MypageDao myDao = new MypageDao();

	public String[] summaryInfo(ShopProfile sp) {
		ShopProfile newsp = myDao.callMemberInfo(sp);

		// 회원정보 DB에 접근해서 받아온 데이터에서 필요한 정보를 뽑는 연산 결과를 아래와 같이 가정함.
		String[] sumInfo = new String[9];
		sumInfo[0] = newsp.getMemberNum(); //회원 번호
		sumInfo[1] = newsp.getShopName(); //상점 이름
		sumInfo[2] = newsp.getShopImageURL(); //프로필 사진 url
		sumInfo[3] = newsp.getShopIntro(); //상점 소개
		sumInfo[4] = newsp.getCountOfOpenDate()+""; //상점 오픈일 NN일 전
		sumInfo[5] = newsp.getCountVisit()+ ""; // 상점 방문 수
		sumInfo[6] = newsp.getCountSell()+ ""; // 판매 수
		sumInfo[7] = newsp.getCountShipping()+ ""; // 배송 횟수
		sumInfo[8] = newsp.isCertified()+ ""; // 본인인증

		return sumInfo;
	}
	public String editShopName(ShopProfile sp, String str) {
		myDao.editShopName(sp, str);
		return "변경 성공!";
	}
	public String editShopImageURL(ShopProfile sp, String str) {
		myDao.editShopImageURL(sp, str);
		return "변경 성공!";
	}
	public String editShopIntro(ShopProfile sp, String str) {
		myDao.editShopIntro(sp, str);
		return "변경 성공!";
	}
	
}

/*
public String[] summaryInfo(ShopProfile sp) {
ShopProfile newsp = myDao.callMemberInfo(sp);

// 회원정보 DB에 접근해서 받아온 데이터에서 필요한 정보를 뽑는 연산 결과를 아래와 같이 가정함.
String[] sumInfo = new String[9];
sumInfo[0] = newsp.getMemberNum(); //회원 번호
sumInfo[1] = newsp.getShopName(); //상점 이름
sumInfo[2] = newsp.getShopImageURL(); //프로필 사진 url
sumInfo[3] = newsp.getShopIntro(); //상점 소개
sumInfo[4] = newsp.getCountOfOpenDate()+""; //상점 오픈일 NN일 전
sumInfo[5] = newsp.getCountVisit()+ ""; // 상점 방문 수
sumInfo[6] = newsp.getCountSell()+ ""; // 판매 수
sumInfo[7] = newsp.getCountShipping()+ ""; // 배송 횟수
sumInfo[8] = newsp.isCertified()+ ""; // 본인인증

return sumInfo;
}

*/