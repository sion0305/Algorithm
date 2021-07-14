package CodeUp;

import java.util.Scanner;

public class Code_1912 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		if(n == 1) return 1;
		
		return n * solution(n-1);
	}
}
