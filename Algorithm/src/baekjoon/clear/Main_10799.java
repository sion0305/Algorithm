package baekjoon.clear;

import java.util.Scanner;
import java.util.Stack;

public class Main_10799 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		Stack<Character> st = new Stack<>();
		int cut = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				st.push(s.charAt(i));
			}else {
				if(s.charAt(i-1) == '(') {
					st.pop();
					cut += st.size();
				}else {
					st.pop();
					cut += 1;
				}
			}
		}
		System.out.println(cut);
	}
}
