package baekjoon.clear;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_1427 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();

		String[] arr = s.split("");
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(String n : arr) {
			System.out.print(n);
		}
	}

}
