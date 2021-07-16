package CodeUp;

import java.util.Scanner;

public class Code_2623 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int div = Math.min(a,b) == a ? a : b;
		
		for(int i = div; i > 1; i--) {
			if(a % i == 0 && b % i == 0) {
				System.out.println(i);
				break;
			}
		}
	}
}
