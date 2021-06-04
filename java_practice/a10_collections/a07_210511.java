package javaexp.a10_collections;

import java.util.Calendar;

public class a07_210511 {

	public enum Cards {HEART, SPACE, CLOVER, DIAMOND};
	
	public static void main(String[] args) {

		System.out.println("1. ==========================");

		int randNum;

		for (int i = 1000; i <= 1020; i++) {

			randNum = (int) (Math.random() * 2);

			System.out.print(i + "\t");

			if (randNum % 2 == 0) {

				System.out.println("홍팀 ");

			} else {

				System.out.println("청팀 ");

			}

		}

		System.out.println("2. ==========================");

		int total = 0, everage = 0, randNum02 = 0;

		for (int i = 1; i < 31; i++) {

			randNum02 = (int) (Math.random() * 101);

			System.out.print(randNum02 + "\t");

			total += randNum02;

			if (i % 10 == 0) {

				System.out.println();

			}

		}

		System.out.println("평균: " + total / 30);

		System.out.println("3. ==========================");

		/*
		 * 
		 * YEAR, MONTH, DATE, DAY_OF_MONTH
		 * 
		 * HOUR, MINUTE, SECOND
		 * 
		 */

		Calendar cal = Calendar.getInstance();

		System.out.println("오늘" + cal.get(Calendar.DAY_OF_MONTH) + "일");
		
		int randDate = (int) (Math.random()*31 +1);
		//set(변경할 상수, 변경할 데이터)
		cal.set(Calendar.DAY_OF_MONTH, randDate);

		System.out.println("임의로는" + cal.get(Calendar.DAY_OF_MONTH) + "일");

		System.out.println("4. ==========================");

		/*
		 * 
		 * 상수를 열거형으로 사용할 때 효과적으로 쓰이는 데이터 유형
		 * 
		 * (열거형 상수)
		 *
		 * 
		 * 
		 */

		Cards[] cards = Cards.values();
		int randIdx = (int)(Math.random()*4);

		System.out.println(cards[randIdx]);

		System.out.println("5. ==========================");

		/*
		 * 
		 * Person[] parry = {new Person(),
		 * 		new Person(),
		 * 		new Person()
		 * };
		 * 
		 */

		Student[] std = {

				new Student("박지성", 10, 20, 30),

				new Student("황런쥔", 20, 25, 30),

				new Student("이마크", 55, 60, 70) };

		for (Student s : std) {

			System.out.println(s.getName() + ": " + s.getKor() + ", " + s.getEng() + ", " + s.getMath());

		}

	}

}

class Student {

	String name;

	int Kor, Eng, Math;

	public Student(String name, int kor, int eng, int math) {

		super();

		this.name = name;

		Kor = kor;

		Eng = eng;

		Math = math;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public int getKor() {

		return Kor;

	}

	public void setKor(int kor) {

		Kor = kor;

	}

	public int getEng() {

		return Eng;

	}

	public void setEng(int eng) {

		Eng = eng;

	}

	public int getMath() {

		return Math;

	}

	public void setMath(int math) {

		Math = math;

	}

}