package baekjoon.clear;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_2217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		Integer[] arr = new Integer[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		int w = arr[0];
		for(int i = 1; i <= n; i++) {
			w = Math.max(w, arr[i-1] * i);
		}
		
		System.out.println(w);
	}

}
