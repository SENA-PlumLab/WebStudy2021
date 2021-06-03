package javaexp.a00_exp.teamP_03;

import java.util.ArrayList;
import java.util.Calendar;

public class MypageDao {

	public MemberProfile callMemberInfo(MemberProfile mp) {
		return mp;
	}

	public ArrayList<OrderedProduct> callOrderInfo(MemberProfile mp) {
		// 아래 orderList에 DB에서 값을 받아와 할당한다.
		// 임의로 아래와 같이 구매이력 데이터를 받아옴
		ArrayList<Product> pList = new ArrayList<Product>();
		pList.add(new Product("P-04311", "컵라면", 6000));
		pList.add(new Product("P-05522", "모니터", 200000));
		pList.add(new Product("P-00121", "거울", 50000));
		ArrayList<OrderedProduct> orderList = new ArrayList<OrderedProduct>();
		orderList.add(new OrderedProduct(pList.get(0), "2018-05-05", "O-00454", order_status.IN_PROGESS));
		orderList.add(new OrderedProduct(pList.get(1), "2018-07-01", "O-00884", order_status.SHIPPED));
		orderList.add(new OrderedProduct(pList.get(2), "2018-07-29", "O-01215", order_status.CANCELLED));

		return orderList;
	}

	public ArrayList<Inquiry> callInquiryInfo(MemberProfile mp) {
		// 아래 inquiryList에 DB에서 값을 받아와 할당한다.
		// 임의로 아래와 같이 문의내역 데이터를 받아 옴
		ArrayList<Inquiry> inquiryList = new ArrayList<Inquiry>();
		inquiryList.add(new Inquiry("문의제목1", "2017-05-02", inquiry_status.REPLIED));
		inquiryList.add(new Inquiry("문의제목2", "2017-12-29", inquiry_status.REPLIED));

		return inquiryList;
	}

	public ArrayList<Product> callCollectionInfo(MemberProfile mp) {
		// 아래 cList에 DB에서 값을 받아와 할당한다.
		// 임의로 아래와 같이 마이컬렉션 데이터를 받아 옴
		ArrayList<Product> cList = new ArrayList<Product>();
		cList.add(new Product("P-00001", "마라탕", 15000));
		cList.add(new Product("P-00462", "초코파이", 2000));
		cList.add(new Product("P-04503", "선풍기", 50000));

		return cList;
	}
}
