package javaexp.a00_exp.teamP_03;

import java.util.ArrayList;

public class PropDao {

	// ====== 쿠폰 =======
	public ArrayList<Coupons> callCoupon(MemberProfile mp) {
		// mp에 해당하는 coupon 정보 받아왔을 때

		ArrayList<Coupons> clist = new ArrayList<Coupons>();
		clist.add(new Coupons("0QTV8560PUIK0PQ1", "회원가입 쿠폰 - 10%할인", "최대 할인액 : 5,000원", coupon_status.NOTUSED,
				"2021-05-29", "2021-06-29"));
		clist.add(new Coupons("2NSRO39ENRO2OSEM", "6월 쿠폰 - 1만원 배송쿠폰", "배송료 10,000원 할인", coupon_status.NOTUSED,
				"2021-06-01", "2021-06-30"));
		clist.add(new Coupons("U2SJDNSE2JEWP1A1", "전자제품 쿠폰 - 30%할인", "최대 할인액 : 15,000원", coupon_status.USED,
				"2021-04-29"));
		return clist;

	}

	// ======= 예치금 ========
	public int callDepositLeft(MemberProfile mp) {
		//// DB에 접근해서 받아온 예치금 잔액을 아래와 같이 가정함.
		int balance = mp.getMemberProp().getDeposit().getBalance();
		return balance;
	}

	public ArrayList<MoneyUsed> callUsedDeposit(MemberProfile mp) {
		// mp에 해당하는 Deposit 정보
		ArrayList<MoneyUsed> deList = new ArrayList<MoneyUsed>();
		deList.add(new MoneyUsed(money_kind.DEPOSIT, "2018-05-05", "P-04311", "예치금 사용", 500));
		deList.add(new MoneyUsed(money_kind.DEPOSIT, "2018-07-01", "P-05522", "예치금 사용", 100000));
		deList.add(new MoneyUsed(money_kind.DEPOSIT, "2018-07-29", "P-00121", "예치금 사용", 10000));

		return deList;
	}

	public String buyDeposit(MemberProfile mp, int amount) {
		// DB의 값을 변경하고 저장함!!
		mp.getMemberProp().getDeposit().add(amount);

		return "구매 성공!";
	}

	public String refundDeposit(MemberProfile mp, int amount) {
		// DB의 값을 변경하고 저장함!!
		mp.getMemberProp().getDeposit().refund(amount);
		return "환불 성공!";
	}

	// ======= 보증금 ========
	public int callGuarantyLeft(MemberProfile mp) {
		//// DB에 접근해서 받아온 예치금 잔액을 아래와 같이 가정함.
		int balance = mp.getMemberProp().getGuaranty().getBalance();
		return balance;
	}

	public ArrayList<MoneyUsed> callUsedGuaranty(MemberProfile mp) {
		// mp에서 고객번호 memberNum을 받아와 DB에서 검색.
		// DB에 접근해서 받아온 보증금 사용내역 데이터를 아래와 같이 가정함.
		ArrayList<MoneyUsed> guList = new ArrayList<MoneyUsed>();
		guList.add(new MoneyUsed(money_kind.GUARANTY, "2018-05-05", "P-04311", "보증금 사용", 500));
		guList.add(new MoneyUsed(money_kind.GUARANTY, "2018-07-01", "P-05522", "보증금 사용", 50000));
		guList.add(new MoneyUsed(money_kind.GUARANTY, "2018-07-29", "P-00121", "보증금 사용", 8000));

		return guList;
	}

	public String buyGuaranty(MemberProfile mp, int amount) {
		// DB의 값을 변경하고 저장함!!
		mp.getMemberProp().getGuaranty().add(amount);
		return "구매 성공!";
	}

	public String refundGuaranty(MemberProfile mp, int amount) {
		// DB의 값을 변경하고 저장함!!
		mp.getMemberProp().getGuaranty().refund(amount);
		return "환불 성공!";
	}
}
