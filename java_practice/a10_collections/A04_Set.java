package javaexp.a10_collections;

import java.util.HashSet;
import java.util.Set;

/*

# Set 하위 객체
1. 중복 불가, 순서확보 안 됨



 */
public class A04_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> set = new HashSet<String>();
		set.add("자바");	
		set.add("jsp");	
		set.add("스프링");	
		set.add("mybatis");	
		set.add("응애");	
		
		System.out.println("# 저장딘 Set객체 #");
		for(String s:set) {
			System.out.println(s);
		}
		
	}

}
