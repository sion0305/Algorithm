package baekjoon;

import java.util.Scanner;

public class Main_1439 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		String[] arr = s.split("");
		
		int count0 = 0;
		int count1 = 0;
		
		if(arr[0].equals("0")) {
			count0++;
		}else {
			count1++;
		}
		
		for(int i = 1; i < arr.length; i++) {
			if(!arr[i-1].equals(arr[i])) {
				if(arr[i].equals("0")) {
					count0++;
				}else {
					count1++;
				}
			}
		}
		
		System.out.println(Math.min(count0, count1));
	}

}
