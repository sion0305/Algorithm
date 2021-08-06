package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_4889 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		for(int j = 1; s.charAt(0) != '-'; j++) {
			Stack<Character> st = new Stack<>();
			int result = 0;
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '{') {
					st.push('{');
				}else {
					if(!st.isEmpty()) {
						st.pop();
					}else {
						st.push('{');
						result += 1;
					}
				}
			}
			result += (st.size()/2);
			System.out.println(j + ". " + result);
			s = sc.nextLine();
		}
	}
}
