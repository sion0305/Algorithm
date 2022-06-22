package baekjoon.clear;

import java.util.Scanner;
import java.util.Stack;

public class Main_17413 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();	//sc.next()��ٰ� ���� �߻�
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
				result.append(s.charAt(i));		//>��� ����
			}else if(s.charAt(i) == ' '){
				while(!st.isEmpty()) {
					result.append(st.pop());
				}
				result.append(s.charAt(i));		//���� ��� ����
			}else {
				st.push(s.charAt(i));
			}
		}
		
		while(!st.isEmpty()) {		//���ÿ� �����ִ� �ֵ� �� ���
			result.append(st.pop());
		}
		
		System.out.println(result);
	}
}
