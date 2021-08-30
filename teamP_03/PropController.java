package javaexp.a00_exp.teamP_03;

import java.util.ArrayList;
import java.util.Scanner;

public class PropController {
PropService prService = new PropService();
	
	// 쿠폰 보유내역
	public String showCoupons(MemberProfile mp, Model d) {
		d.addAttribute("보유 쿠폰", prService.showCoupon(mp));

		//임의로 출력하면...
		ArrayList<Coupons> couponList = prService.showCoupon(mp);
		System.out.println("--------------------");
		System.out.println("쿠폰정보\t\t\t쿠폰이름\t\t\t사용구분\t제한조건\t\t\t등록일\t\t유효기간\t");
		for (int i = couponList.size() - 1; i >= 0; i--) { // 역순 출력
			System.out.print(couponList.get(i).getCouponNum() 
							+"\t("+couponList.get(i).getName()+")\t");
			System.out.print(couponList.get(i).getStatus().toString() + "\t");
			System.out.print(couponList.get(i).getLimit()+ "\t");
			System.out.print(couponList.get(i).getRegDate()+ "\t");
			System.out.print(couponList.get(i).getLimitDate()+ "\t");
			System.out.println("");
		}
		System.out.println("--------------------");
		
		return "호출화면";
	}
	
	// 쿠폰 사용내역
	public String showCouponsUsed(MemberProfile mp, Model d) {
		d.addAttribute("쿠폰 사용내역", prService.usedCoupon(mp));

		// 데이터를 Model로 받아와서 출력하면
		ArrayList<Coupons> couponList = prService.usedCoupon(mp);
		System.out.println("--------------------");
		System.out.println("쿠폰정보\t\t\t쿠폰이름\t\t\t사용구분\t제한조건\t\t\t사용일자");
		for (int i = couponList.size() - 1; i >= 0; i--) { // 역순 출력
			System.out.print(couponList.get(i).getCouponNum() 
							+"\t("+couponList.get(i).getName()+")\t");
			System.out.print(couponList.get(i).getStatus().toString() + "\t");
			System.out.print(couponList.get(i).getLimit()+ "\t");
			System.out.print(couponList.get(i).getUsedDate()+ "\t");
			System.out.println("");
		}
		System.out.println("--------------------");
		
		return "호출화면";
	}
	

	// 예치금 잔액표시
	public String showDeposit(MemberProfile mp, Model d) {
		d.addAttribute("예치금 잔액", prService.showDepositLeft(mp));

		//임의로 출력하면...
		System.out.println("--------------------");
		System.out.println(mp.getName() + "님 예치금 잔액: " + prService.showDepositLeft(mp));
		System.out.println("--------------------");

		return "호출화면";
	}

	// 예치금 사용내역 표시
	public String showDepositUsed(MemberProfile mp, Model d) {
		d.addAttribute("예치금 사용내역", prService.usedDeposit(mp));

		//임의로 출력하면...
		ArrayList<MoneyUsed> usedDepositList = prService.usedDeposit(mp);
		System.out.println("--------------------");
		System.out.println("일자\t\t관련정보\t구분\t금액\t내역\t");
		for (int i = usedDepositList.size() - 1; i >= 0; i--) { // 역순 출력
			System.out.print(usedDepositList.get(i).getUsedDate() + "\t");
			System.out.print(usedDepositList.get(i).getProductNum() + "\t");
			System.out.print(usedDepositList.get(i).getKind().toString() + "\t");
			System.out.print(usedDepositList.get(i).getAmount() + "\t");
			System.out.print(usedDepositList.get(i).getInfo() + "\t");
			System.out.println("");
		}
		System.out.println("--------------------");
		return "호출화면";
	}

	// 예치금 구매
	public String buyDeposit(MemberProfile mp, Model d) {
		d.addAttribute("예치금 구매", prService.buyDeposit(mp, 0)); // 0원 구매

		//임의로 출력하면...
		System.out.println("--------------------");
		Scanner sc1 = new Scanner(System.in);
		System.out.print("예치금 구매하겠습니까? (Y/N): ");
		if (sc1.nextLine().equals("Y")) {
			System.out.print("** 구매 액수 입력: ");
			int amount = sc1.nextInt();
			System.out.println(prService.buyDeposit(mp, amount));
			System.out.println("구매 후 잔액: " + prService.showDepositLeft(mp));
		}
		System.out.println("--------------------");

		return "호출화면";
	}

	// 예치금 환불
	public String refundDeposit(MemberProfile mp, Model d) {
		d.addAttribute("예치금 환불", prService.refundDeposit(mp, 0)); // 0원 환불

		//임의로 출력하면...
		System.out.println("--------------------");
		System.out.print("예치금 환불하시겠습니까? (Y/N): ");
		Scanner sc2 = new Scanner(System.in);
		if (sc2.nextLine().equals("Y")) {
			System.out.print("** 환불 액수 입력: ");
			int amount = sc2.nextInt();
			System.out.println(prService.refundDeposit(mp, amount));
			System.out.println("환불 후 잔액: " + prService.showDepositLeft(mp));
		}
		System.out.println("--------------------");

		return "호출화면";
	}

	// ===================
	// 보증금 잔액표시
	public String showGuaranty(MemberProfile mp, Model d) {
		d.addAttribute("보증금 잔액", prService.showGuarantyLeft(mp));

		//임의로 출력하면...
		System.out.println("--------------------");
		System.out.println(mp.getName() + "님 보증금 잔액: " + prService.showGuarantyLeft(mp));
		System.out.println("--------------------");

		return "호출화면";
	}

	//보증금 사용내역 표시
	public String showGuarantyUsed(MemberProfile mp, Model d) {
		d.addAttribute("보증금 사용내역", prService.usedGuaranty(mp));

		//임의로 출력하면...
		ArrayList<MoneyUsed> usedGuarantyList = prService.usedGuaranty(mp);
		System.out.println("--------------------");
		System.out.println("일자\t\t관련정보\t구분\t\t금액\t내역\t");
		for (int i = usedGuarantyList.size() - 1; i >= 0; i--) { // 역순 출력
			System.out.print(usedGuarantyList.get(i).getUsedDate() + "\t");
			System.out.print(usedGuarantyList.get(i).getProductNum() + "\t");
			System.out.print(usedGuarantyList.get(i).getKind().toString() + "\t");
			System.out.print(usedGuarantyList.get(i).getAmount() + "\t");
			System.out.print(usedGuarantyList.get(i).getInfo() + "\t");
			System.out.println("");
		}
		System.out.println("--------------------");
		return "호출화면";
	}
	// 보증금 구매
	public String buyGuaranty(MemberProfile mp, Model d) {
		d.addAttribute("보증금 구매", prService.buyGuaranty(mp, 0)); // 0원 구매

		//임의로 출력하면...
		System.out.println("--------------------");
		Scanner sc1 = new Scanner(System.in);
		System.out.print("보증금 구매하겠습니까? (Y/N): ");
		if (sc1.nextLine().equals("Y")) {
			System.out.print("** 구매 액수 입력: ");
			int amount = sc1.nextInt();
			System.out.println(prService.buyGuaranty(mp, amount));
			System.out.println("구매 후 잔액: " + prService.showGuarantyLeft(mp));
		}
		System.out.println("--------------------");

		return "호출화면";
	}

	// 보증금 환불
	public String refundGuaranty(MemberProfile mp, Model d) {
		d.addAttribute("보증금 환불", prService.refundGuaranty(mp, 0)); // 0원 환불

		//임의로 출력하면...
		System.out.println("--------------------");
		System.out.print("보증금 환불하시겠습니까? (Y/N): ");
		Scanner sc2 = new Scanner(System.in);
		if (sc2.nextLine().equals("Y")) {
			System.out.print("** 환불 액수 입력: ");
			int amount = sc2.nextInt();
			System.out.println(prService.refundGuaranty(mp, amount));
			System.out.println("환불 후 잔액: " + prService.showGuarantyLeft(mp));
		}
		System.out.println("--------------------");

		return "호출화면";
	}
}
