package CodeUp;

import java.util.Scanner;

public class Code_3702 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.println(solution(r,c));
	}

	public static int solution(int r, int c) {
		if(r == 1 || c == 1) {
			return 1;
		}
		
		return solution(r-1, c) + solution(r, c-1);
	}
}
