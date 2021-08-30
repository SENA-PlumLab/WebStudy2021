package javaexp.a00_exp.teamP_03;

public class Mypage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MypageController myCon = new MypageController();
		PropController prCon = new PropController();
		UpdateinfoController upCon = new UpdateinfoController();
		
		//DB 기본값 임의로 설정
		MemberProfile mp = new MemberProfile("M0002154", member_grade.GRADE2, 
									"홍길동", "010-1234-5678", null, "qwerty@gamil.com", "true");
		mp.getMemberProp().getDeposit().setBalance(15000);
		mp.getMemberProp().getGuaranty().setBalance(20000);
		
		
		Model m = new Model();
		
		System.out.println("========회원정보 요약표시========");
		myCon.showSummary(mp, m);
		System.out.println("============================\n");
		System.out.println("========최근 주문내역========");
		myCon.showOrderSum(mp, m);
		System.out.println("============================\n");
		System.out.println("========최근 문의내역========");
		myCon.showInquiry(mp, m);
		System.out.println("============================\n");
		System.out.println("========마이컬렉션========");
		myCon.collectionInfo(mp, m);
		System.out.println("============================\n");
		
		
		System.out.println("========보유 쿠폰========");
		prCon.showCoupons(mp, m);
		System.out.println("===========================\n");
		System.out.println("========쿠폰 사용내역========");
		prCon.showCouponsUsed(mp, m);
		System.out.println("============================\n");
		
		System.out.println("========예치금 잔액========");
		prCon.showDeposit(mp, m);
		System.out.println("============================\n");
		System.out.println("========예치금 사용내역=======");
		prCon.showDepositUsed(mp, m);
		System.out.println("============================\n");
		System.out.println("========예치금 구매========");
		prCon.buyDeposit(mp, m);
		System.out.println("============================\n");
		System.out.println("========예치금 환불========");
		prCon.refundDeposit(mp, m);
		System.out.println("============================\n");
		
		System.out.println("========보증금 잔액========");
		prCon.showGuaranty(mp, m);
		System.out.println("============================\n");
		System.out.println("========보증금 사용내역========");
		prCon.showGuarantyUsed(mp, m);
		System.out.println("============================\n");
		System.out.println("========보증금 구매========");
		prCon.buyGuaranty(mp, m);
		System.out.println("============================\n");
		System.out.println("========보증금 환불========");
		prCon.refundGuaranty(mp, m);
		System.out.println("============================\n");
		
		System.out.println("========회원정보========");
		upCon.showMemberInform(mp, m);
		System.out.println("============================\n");
		System.out.println("========휴대폰 번호 수정========");
		upCon.editPhone(mp, m);
		System.out.println("============================\n");
		System.out.println("========통관 번호 수정========");
		upCon.editPccc(mp, m);
		System.out.println("============================\n");
		System.out.println("========이메일 수정========");
		upCon.editEmail(mp, m);
		System.out.println("============================\n");
		System.out.println("========정보제공동의 수정========");
		upCon.editAble(mp, m);
		System.out.println("============================\n");
		System.out.println("========회원정보(Updated)========");
		upCon.showMemberInform(mp, m);
		System.out.println("============================\n");
		
	}

}
