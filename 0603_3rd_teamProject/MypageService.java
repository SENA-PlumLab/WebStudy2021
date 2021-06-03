package javaexp.a00_exp.teamP_03;

import java.util.ArrayList;

public class MypageService {

	MypageDao myDao = new MypageDao();

	public String[] summaryInfo(MemberProfile mp) {
		MemberProfile newMp = myDao.callMemberInfo(mp);

		// 회원정보 DB에 접근해서 받아온 데이터에서 필요한 정보를 뽑는 연산 결과를 아래와 같이 가정함.
		String[] sumInfo = new String[5];
		sumInfo[0] = newMp.getName(); // 회원 이름
		sumInfo[1] = newMp.getGrade().toString(); // 회원등급
		sumInfo[2] = "4"; // 쿠폰 갯수(임의의 값)
		sumInfo[3] = newMp.getMemberProp().getDeposit().getBalance() + ""; // 예치금 잔액
		sumInfo[4] = newMp.getMemberProp().getGuaranty().getBalance() + ""; // 보증금 잔액

		return sumInfo;
	}

	public ArrayList<OrderedProduct> orderSumInfo(MemberProfile mp) {
		ArrayList<OrderedProduct> orderList = myDao.callOrderInfo(mp);
		// 검색 로직에 따라 한달 이상 된 검색기록 삭제
		orderList.remove(0);
		orderList.remove(1);
		return orderList;
	}

	public ArrayList<Inquiry> inquirySumInfo(MemberProfile mp) {
		ArrayList<Inquiry> inquiryList = myDao.callInquiryInfo(mp);
		// 검색 로직에 따라 한달 이상 된 검색기록 삭제
		inquiryList.remove(1);
		return inquiryList;
	}

	public ArrayList<Product> collectionInfo(MemberProfile mp) {
		ArrayList<Product> cList = myDao.callCollectionInfo(mp);
		return cList;
	}
}
