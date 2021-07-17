package CodeUp;

import java.util.Scanner;

public class Code_2650 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] key = new int[3];
		
		int min = 1001;
		for(int i = 0; i < 3; i++) {
			key[i] = sc.nextInt();
			min = Math.min(min, key[i]);
		}
		
		for(int i = min; i > 1; i--) {
			if(key[0] % i == 0 && key[1] % i == 0 && key[2] % i == 0) {
				System.out.println(i);
				break;
			}
		}
		System.out.println("¾øÀ½");
	}

}
