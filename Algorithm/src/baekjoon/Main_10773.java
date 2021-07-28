package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_10773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			int m = sc.nextInt();
			if(m == 0) {
				st.pop();
			}else {
				st.push(m);
			}
		}
		
		int sum = 0;
		for(int i = 0; !st.isEmpty(); i++) {
			sum += st.pop();
		}
		
		System.out.println(sum);
	}
}
