package baekjoon.clear;

import java.util.*;

public class Main_3273 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int sum = sc.nextInt();
		int count = 0;
		
		int start = 0;
		int end = n-1;
		
		while(start < end) {
			int tmp = arr[start] + arr[end];
			if(sum == tmp) {
				count++;
				end--;
				start++;
			}else if(tmp > sum) {
				end--;
			}else if(tmp < sum) {
				start++;
			}
		}
	
		
		System.out.println(count);
	}

}
