package javaexp.a08_api;


//입력: 수박 12000 3 바나나 4000 5

class Fruit {
	String name;
	int price, cnt;
	
	public Fruit(String name, int price, int cnt) {
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	
	/*
	public void set_name ( String name ) {
		this.name = name;
	}
	public void set_price ( int price ) {
		this.price = price;
	}
	public void set_cnt ( int cnt ) {
		this.cnt = cnt;
	}
	*/
	
}



public class A04_TypeTransfer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Fruit fr01 = new Fruit(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		Fruit fr02 = new Fruit(args[3], Integer.parseInt(args[4]), Integer.parseInt(args[5]));

		System.out.println(fr01.name+", "+fr01.price+"원, "+fr01.cnt+"개 = "+(fr01.price * fr01.cnt));
		System.out.println(fr02.name+", "+fr02.price+"원, "+fr02.cnt+"개 = "+(fr02.price * fr02.cnt));
		
		System.out.println("---------------------");
		
		System.out.println("물건명\t가격\t갯수\t계");
		System.out.println(fr01.name+"\t"+fr01.price+"\t"+fr01.cnt+"\t"+(fr01.price * fr01.cnt));
		System.out.println(fr02.name+"\t"+fr02.price+"\t"+fr02.cnt+"\t"+(fr02.price * fr02.cnt));

		
		
		

	}

}
