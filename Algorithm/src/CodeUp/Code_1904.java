package CodeUp;

import java.util.Scanner;

public class Code_1904 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();

		solution(a, b);
	}

	public static void solution(int a, int b) {
		if(a > b)
			return;
		
		if(a % 2 == 1) {
			System.out.print(a + " ");
		}
		solution(a+1, b);
	}
}
