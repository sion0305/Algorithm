package baekjoon;

//import java.util.Scanner;

public class Main_4673 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		
//		int n = sc.nextInt();
		boolean[] check = new boolean[10001];
		
		for(int i = 1; i < 10001; i++) {
			int n = solution(i);
			
			if(n < 10001) {
				check[n] = true;
			}
		}
		
		for(int i = 1; i < 10001; i++) {
			if(!check[i]) {
				System.out.println(i);
			}
		}
	}

	public static int solution(int n) {
		int sum = n;
		
		while(n != 0) {
			sum += n % 10;
			n /= 10;
		}
		
		return sum;
	}
}