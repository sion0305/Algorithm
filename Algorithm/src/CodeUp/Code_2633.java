package CodeUp;

import java.util.Scanner;

public class Code_2633 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			
			if(arr[i] >= k) {
				System.out.println(i+1);
				return;
			}
			
		}
		System.out.println(n+1);
		
	}

}
