package baekjoon.clear;

import java.util.*;

public class Main_9012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < n; i++) {
			String s = sc.nextLine();
			
			System.out.println(isVPS(s));
		}
			
	}
	
	public static String isVPS(String s) {
		Stack<Character> st = new Stack<>();
		
		for(int j = 0; j < s.length(); j++) {
			if(s.charAt(j) == '(') {
				st.add(s.charAt(j));
			}else {
				if(st.isEmpty())
					return "NO";
				
				st.pop();
			}
		}
		if(st.isEmpty())
			return "YES";
		
		return "NO";
	}

}
