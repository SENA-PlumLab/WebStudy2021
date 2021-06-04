package javaexp.a08_api;

import java.util.Calendar;

/*

# 날짜 데이터 처리 클래서 Calendar

1. 기본적으로 데이터의 처리방식이
	시간==> 일 => 주 => 월 => 년. 단위로 처리되는 객체를 생성하고 활용할 수 있게 처리해 줌,


 */



public class A07_Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Calendar cal = Calendar.getInstance();
		System.out.println();
		
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(hour+"시 "+minute+"분 "+second+"초");
		
		Calendar cal3 = Calendar.getInstance();
		
		
	}

}
