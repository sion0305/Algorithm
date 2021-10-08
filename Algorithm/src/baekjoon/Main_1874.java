package baekjoon;

import java.util.*;

public class Main_1874 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		int N = in.nextInt();
		
		int start = 0;
		
		// N �� �ݺ�
		while(N -- > 0) {
			
			int value = in.nextInt();
			
			if(value > start) {
				for(int i = start + 1; i <= value; i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				start = value;
			}
			//���ÿ� �����ִ� �������ڰ� value�� ���� ���� �ƴϸ� 
			else if(stack.peek() != value) {
				System.out.println("NO");
				return;	
			}
			
			stack.pop();
			sb.append('-').append('\n');
			
		}
		
		System.out.println(sb);
		
	}

}
