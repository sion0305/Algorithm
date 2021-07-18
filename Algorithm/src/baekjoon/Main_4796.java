package baekjoon;

import java.util.Scanner;

public class Main_4796 {//캠핑

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; ; i++) {
			int l = sc.nextInt();
			int p = sc.nextInt();
			int v = sc.nextInt();
			
			if(p == 0 && l == 0 && v == 0)
				break;
			
			int count = (v / p) * l + Math.min(l,(v % p));
			//만약 p가 8이고 l이 5인데, v%p가 7이라면 l과 v%p 중 더 작은숫자를 더해주어야한다. 
					
			System.out.println("Case " + i + ": " + count);
		}
	}
}
