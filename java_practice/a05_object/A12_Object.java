package javaexp.a05_object;

import java.util.ArrayList;
import java.util.Scanner;

public class A12_Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("===== Schedule =====");
		
		ArrayList<Schedule> slist = new ArrayList();
		slist.add(new Schedule(1,"밥먹기"));
		slist.add(new Schedule(4,"과제"));
		slist.add(new Schedule(2,"복습하는척 놀기"));
		
		int less = 0;
		
		for(int i=0; i<slist.size(); i++) {
			System.out.print((i+1)+") "+slist.get(i).getTodo()+" 실제 소요 시간: ");
			less = sc1.nextInt();
			System.out.println(slist.get(i).getTodo()+"("+slist.get(i).getUntil()+"시간 예상) --> 실제 "+
								less+"시간 소요");
			System.out.println(" => 실행시간 차이:"+slist.get(i).lessTime(less)+"시간");
		}
		
		
	}

}



class Schedule {
	private int until;
	private String todo;
	
	
	
	public Schedule(int until, String todo) {
		super();
		this.until = until;
		this.todo = todo;
	}
	
	public int lessTime(int needed) {
		
		return needed - until; //예상보다 오래걸렸을 경우 양수, 덜 걸렸을 경우 음수.
	}

	public int getUntil() {
		return until;
	}

	public String getTodo() {
		return todo;
	}

	public void setUntil(int until) {
		this.until = until;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}
	
}