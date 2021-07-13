package CodeUp;

import java.util.Scanner;

public class Code_1020 {//StringÀ¸·Î Ç®¾îº½

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		
		s = s.replaceAll("-", "");
		
		System.out.println(s);
	}

}
