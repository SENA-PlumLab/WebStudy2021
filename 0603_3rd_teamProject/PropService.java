package javaexp.a00_exp.teamP_03;

import java.util.ArrayList;

public class PropService {
	PropDao prDao = new PropDao();
	// ====== 쿠폰 =======

		public ArrayList<Coupons> showCoupon(MemberProfile mp){
			ArrayList<Coupons> clist = prDao.callCoupon(mp);
			
			//보유중인 쿠폰만!
			int count = clist.size();
			for(int i=0; i<count; i++) {
				if(clist.get(i).getStatus() != coupon_status.NOTUSED ) {
					clist.remove(i);
					i--;
					count--;
				}
			}
			
			return clist;
		}
		
		public ArrayList<Coupons> usedCoupon(MemberProfile mp){
			ArrayList<Coupons> clist = prDao.callCoupon(mp);
			
			//이미 소모된 쿠폰만!
			int count = clist.size();
			for(int i=0; i<count; i++) {
				if(clist.get(i).getStatus() == coupon_status.NOTUSED) {
					clist.remove(i);
					i--;
					count--;
				}
			}
			return clist;
		}
		
		
		
		// ======= 예치금 ========
		public int showDepositLeft(MemberProfile mp) {
			//// DB에 접근해서 받아온 예치금 잔액을 아래와 같이 가정함.
			int balance = prDao.callDepositLeft(mp);
			return balance;
		}

		public ArrayList<MoneyUsed> usedDeposit(MemberProfile mp) {
			// mp에서 고객번호 memberNum을 받아와 DB에서 검색.
			// DB에 접근해서 받아온 예치금 사용내역 데이터를 아래와 같이 가정함.
			ArrayList<MoneyUsed> deList = prDao.callUsedDeposit(mp);
			return deList;
		}

		public String buyDeposit(MemberProfile mp, int amount) {
			prDao.buyDeposit(mp, amount);
			return "구매 성공!";
		}

		public String refundDeposit(MemberProfile mp, int amount) {
			int balance = prDao.callDepositLeft(mp);
			if (amount > balance) {
				return "환불 실패!";
			}
			prDao.refundDeposit(mp, amount);
			return "환불 성공!";
		}

		// ======= 보증금 ========
		public int showGuarantyLeft(MemberProfile mp) {
			//// DB에 접근해서 받아온 예치금 잔액을 아래와 같이 가정함.
			int balance = prDao.callGuarantyLeft(mp);
			return balance;
		}

		public ArrayList<MoneyUsed> usedGuaranty(MemberProfile mp) {
			// mp에서 고객번호 memberNum을 받아와 DB에서 검색.
			// DB에 접근해서 받아온 보증금 사용내역 데이터를 아래와 같이 가정함.
			ArrayList<MoneyUsed> guList = prDao.callUsedGuaranty(mp);
			return guList;
		}

		public String buyGuaranty(MemberProfile mp, int amount) {
			prDao.buyGuaranty(mp, amount);
			return "구매 성공!";
		}

		public String refundGuaranty(MemberProfile mp, int amount) {
			int balance = prDao.callGuarantyLeft(mp);
			if (amount > balance) {
				return "환불 실패!";
			}
			prDao.refundGuaranty(mp, amount);
			return "환불 성공!";
		}
}
