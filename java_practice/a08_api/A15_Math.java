package javaexp.a08_api;

import java.text.DecimalFormat;

public class A15_Math {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int dice1 = (int)(Math.random()*6+1);
		int dice2 = (int)(Math.random()*6+1);
		
		System.out.println("승: "+dice1);
		System.out.println("패: "+dice2);
		
		double num01 = (Math.random()*100);
		DecimalFormat df= new DecimalFormat("0.0");
		System.out.println(df.format(num01));
		num01 = Double.parseDouble(df.format(num01));
		System.out.println("내림: "+Math.floor(num01));
		System.out.println("올림: "+Math.ceil(num01));
		System.out.println("반올림: "+Math.round(num01));
		
		double num02 = (int)(Math.random()*1000) /10.0;
		System.out.println(num02);
		System.out.println("내림: "+Math.floor(num02));
		System.out.println("올림: "+Math.ceil(num02));
		System.out.println("반올림: "+Math.round(num02));
	}

}
