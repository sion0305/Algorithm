package CodeUp;

import java.util.Scanner;

public class Code_1018 {//StringÀ¸·Î Ç®¾îº½
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		String[] time = s.split(":");
		
		System.out.println(time[0] + " : " + time[1]);
	}

}
