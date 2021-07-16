package CodeUp;

import java.util.Scanner;

public class Code_2625 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int length = sc.nextInt();
		int count = 0;
		
		for(int i = 1; i < length; i++) {
			for(int j = 1; j < length; j++) {
				for(int k = 1; k < length; k++) {
					if(i <= j && j <= k && i + j + k == length && i + j > k) {
						count++;
					}
				}
			}
		}
		
		System.out.println(count);
	}

}
