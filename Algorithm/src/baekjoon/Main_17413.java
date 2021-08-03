package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_17413 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();	//sc.next()썼다가 오류 발생
		StringBuilder result = new StringBuilder();
//		String rslt = "";
		
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '<') {
				while(!st.isEmpty()) {
					result.append(st.pop());
				}
				while(s.charAt(i) != '>'){
					result.append(s.charAt(i));
					i++;
				}
				result.append(s.charAt(i));		//>출력 목적
			}else if(s.charAt(i) == ' '){
				while(!st.isEmpty()) {
					result.append(st.pop());
				}
				result.append(s.charAt(i));		//공백 출력 목적
			}else {
				st.push(s.charAt(i));
			}
		}
		
		while(!st.isEmpty()) {		//스택에 남아있는 애들 다 출력
			result.append(st.pop());
		}
		
		System.out.println(result);
	}
}
