package javaexp.a00_exp.teamP_03;

import java.util.ArrayList;
import java.util.Scanner;

public class MypageController {
	MypageService myService = new MypageService();
	//회원정보 요약
	public String showSummary(MemberProfile mp, Model d) {
		d.addAttribute("회원정보 요약", myService.summaryInfo(mp));	
		
		//임의로 출력하면...
		String[] sumInfo = myService.summaryInfo(mp);
		System.out.println("--------------------");
		System.out.println(sumInfo[0]+"님 환영합니다!");
		System.out.println("회원등급:"+sumInfo[1]+", 쿠폰 "+sumInfo[2]+"개, 예치금:"+sumInfo[3]+"원, 보증금:"+sumInfo[4]+"원");
		System.out.println("--------------------");
		return "회원정보 요약 출력";
	}
	//최근주문내역
	public String showOrderSum(MemberProfile mp, Model d) {
		d.addAttribute("최근주문내역", myService.orderSumInfo(mp));	
		
		//임의로 출력해보면...
		ArrayList<OrderedProduct> orderList = myService.orderSumInfo(mp);
		System.out.println("--------------------");
		System.out.println("주문일\t\t주문번호\t상품번호\t상품명\t주문상태\t");
		for(int i=orderList.size()-1; i>=0; i--) { //역순 출력
			System.out.print(orderList.get(i).getOrderDate()+"\t");
			System.out.print(orderList.get(i).getOrderNum()+"\t");
			System.out.print(orderList.get(i).getProdutNum()+"\t");
			System.out.print(orderList.get(i).getName()+"\t");
			System.out.print(orderList.get(i).getStatus().toString()+"\t");
			System.out.println("");
		}
		System.out.println("--------------------");
		return "호출화면";
	}
	
	//최근문의내역
	public String showInquiry(MemberProfile mp, Model d) {
		d.addAttribute("최근주문내역", myService.inquirySumInfo(mp));
		
		//임의로 출력해보면...
		ArrayList<Inquiry> inquiryList = myService.inquirySumInfo(mp);
		System.out.println("--------------------");
		System.out.println("문의제목\t접수일자\t\t상태\t");
		for(int i=inquiryList.size()-1; i>=0; i--) { //역순 출력
			System.out.print(inquiryList.get(i).getTitle()+"\t");
			System.out.print(inquiryList.get(i).getDate()+"\t");
			System.out.print(inquiryList.get(i).getStatus().toString()+"\t");
			System.out.println("");
		}
		System.out.println("--------------------");
		
		return "호출화면";
	}
	//마이컬렉션
	public String collectionInfo(MemberProfile mp, Model d) {
		d.addAttribute("마이컬렉션", myService.collectionInfo(mp));	
		
		//임의로 출력해보면...
		ArrayList<Product> collectList = myService.collectionInfo(mp);
		System.out.println("--------------------");
		System.out.println("상품번호\t상품명\t가격\t");
		for(int i=collectList.size()-1; i>=0; i--) { //역순 출력
			System.out.print(collectList.get(i).getProductNum()+"\t");
			System.out.print(collectList.get(i).getName()+"\t");
			System.out.print(collectList.get(i).getPrice()+"\t");
			System.out.println("");
		}
		System.out.println("--------------------");

		return "호출화면";
	}
}

