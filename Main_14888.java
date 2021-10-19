package baekjoon;

import java.util.Scanner;

public class Main_14888 {
	static int n;
	static int[] nums, ops;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		nums = new int[n];
		ops = new int[4];

		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			ops[i] = sc.nextInt();
		}

		dfs(nums[0], 1);
		
		System.out.println(max);
		System.out.println(min);

	}

	public static void dfs(int num, int idx) {
		if (idx == n) {
			max = Math.max(max, num);
			min = Math.min(max, num);
			return;
		}

		for (int i = 0; i < 4; i++) {

			if (ops[i] > 0) {
				
				ops[i]--;
				
				switch (i) {

					case 0:
						dfs(num + nums[idx], idx + 1);
						break;
					case 1:
						dfs(num - nums[idx], idx + 1);
						break;
					case 2:
						dfs(num * nums[idx], idx + 1);
						break;
					case 3:
						dfs(num / nums[idx], idx + 1);
						break;

				}
				ops[i]++;
			}
		}

	}
}
