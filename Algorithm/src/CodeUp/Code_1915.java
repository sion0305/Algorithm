package CodeUp;

import java.util.Scanner;

public class Code_1915 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		if(n <= 2)
			return 1;
		
		return solution(n-1) + solution(n-2);
	}
}
