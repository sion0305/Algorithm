package CodeUp;

import java.util.Scanner;

public class Code_1020 {//String���� Ǯ�

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		
		s = s.replaceAll("-", "");
		
		System.out.println(s);
	}

}
