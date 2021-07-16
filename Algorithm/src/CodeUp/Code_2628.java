package CodeUp;

import java.util.Arrays;
import java.util.Scanner;

public class Code_2628 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] a = new int[2];
		int[] b = new int[2];
		
		a[0] = sc.nextInt();
		a[1] = sc.nextInt();
		b[0] = sc.nextInt();
		b[1] = sc.nextInt();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		if(b[0] > a[0] && b[0] < a[1]) {
			if(b[1] > a[1])
				System.out.println("cross");
			else
				System.out.println("not cross");
		}
		
		else if(b[1] > a[0] && b[1] < a[1]) {
			if(b[0] < a[0])
				System.out.println("cross");
			else
				System.out.println("not cross");
		}
		
		else
			System.out.println("not cross");
	}

}
