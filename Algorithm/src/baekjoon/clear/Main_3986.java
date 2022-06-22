package baekjoon.clear;

import java.util.Scanner;
import java.util.Stack;

public class Main_3986 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		String[] s = new String[num];
		Stack<Character> st = new Stack<>();
		
		int good = 0;
		
		for(int i = 0; i < num; i++) {
			s[i] = sc.next();
//			String input = sc.next();
			for(int j = 0; j < s[i].length(); j++) {
				if(st.size() > 0 && st.peek() == s[i].charAt(j)) {
					st.pop();
				}else {
					st.add(s[i].charAt(j));
				}
			}
			if(st.size() == 0) {
				good += 1;
			}
			st.clear();
		}
		System.out.println(good);
	}
}
