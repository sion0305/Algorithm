package baekjoon.clear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main_2108 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] nums = new int[n];
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		double sum = 0;
		int max = -4001, min = 4001;
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
			sum += nums[i];
			hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
			if(max < nums[i]) {
				max = nums[i];
			}
			if(min > nums[i]) {
				min = nums[i];
			}
		}

		System.out.println(Math.round(sum/(double)n));
		
		Arrays.sort(nums);
		
		System.out.println(nums[n/2]);
		
		int mode = 0;
		Set<Integer> hs = hm.keySet();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int num : hs) {
			if(hm.get(num) > mode) {
				mode = hm.get(num);
				arr.clear();
			}
			if(hm.get(num) == mode) {
				arr.add(num);
			}
		}
		
		Collections.sort(arr);
		
		if(arr.size() == 1) {
			System.out.println(arr.get(0));
		}else if(arr.size() > 1) {
			System.out.println(arr.get(1));
		}
		
		System.out.println(max - min);
	}

}
