package baekjoon.clear;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main_1935 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String s = sc.next();

		Map<Character, Double> m = new HashMap<>();
		Stack<Double> st = new Stack<>();

		for (int i = 0; i < n; i++) {
			char c = (char) ('A' + i);
			m.put(c, sc.nextDouble());//'A',1
		}

		double result = 0.0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				st.push(m.get(s.charAt(i)));
			} else if (s.charAt(i) == '*') {
				result = st.pop() * st.pop();
				st.push(result);
			} else if (s.charAt(i) == '/') {
				double n2 = st.pop();
				double n1 = st.pop();

				result = n1 / n2;
				st.push(result);
			} else if (s.charAt(i) == '+') {
				result = st.pop() + st.pop();
				st.push(result);
			} else {
				double n2 = st.pop();
				double n1 = st.pop();

				result = n1 - n2;
				st.push(result);
			}
		}
		
		System.out.println(String.format("%.2f", st.pop()));
		//System.out.format("%.2f", st.pop());
	}
}
