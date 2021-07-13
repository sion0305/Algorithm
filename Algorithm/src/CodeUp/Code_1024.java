package CodeUp;

import java.util.Scanner;

public class Code_1024 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		double d = sc.nextDouble();
		String s = sc.next();
		
		String[] word = s.split("");
		
		for(String w : word) {
			System.out.println("'" + w + "'");
		}
		
	}

}
