package baekjoon.clear;

import java.util.Scanner;

public class Main_4796 {//ķ��

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; ; i++) {
			int l = sc.nextInt();
			int p = sc.nextInt();
			int v = sc.nextInt();
			
			if(p == 0 && l == 0 && v == 0)
				break;
			
			int count = (v / p) * l + Math.min(l,(v % p));
			//���� p�� 8�̰� l�� 5�ε�, v%p�� 7�̶�� l�� v%p �� �� �������ڸ� �����־���Ѵ�. 
					
			System.out.println("Case " + i + ": " + count);
		}
	}
}
