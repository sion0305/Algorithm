package CodeUp;

import java.util.Scanner;

public class Code_2651 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		
		System.out.println(solution(n,k));
	}
	
	public static int solution(int n, int k) {
		if(n == 1 || k == n) {
			return 1;
		}else if(k == 1){
			return n;
		}else {
			return solution(n-1, k-1) + solution(n-1, k);
		}
	}

}
