package baekjoon.clear;

import java.util.*;

public class Main_2632 {
	static int target;
	static int m;
	static int n;
	static int[] A;
	static int[] B;
	static boolean[] check;
	static ArrayList<Integer> AList = new ArrayList<>();
	static ArrayList<Integer> BList = new ArrayList<>();
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		target = sc.nextInt();
		m = sc.nextInt();
		n = sc.nextInt();

		A = new int[m];
		B = new int[n];

		for (int i = 0; i < m; i++) {
			A[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			B[i] = sc.nextInt();
		}

		// A ���ڿ� ���� �κ��� �����
		for (int i = 0; i < m; i++) {
			check = new boolean[m];
			check[i] = true;
			getSum(A[i], i, i + 1, check, A, AList);
		}
		// B ���ڿ� ���� �κ��� �����
		for (int i = 0; i < n; i++) {
			check = new boolean[n];
			check[i] = true;
			getSum(B[i], i, i + 1, check, B, BList);
		}

		AList.add(0);
		BList.add(0);

		Collections.sort(AList);
		Collections.sort(BList);

		int leftIdx = 0;
		int rightIdx = BList.size() - 1;

		while (leftIdx < AList.size() && rightIdx >= 0) {// �� �迭 ������ �ȿ��� ����
			// left, right index�� value ������.
			int lv = AList.get(leftIdx);
			int rv = BList.get(rightIdx);

			if (lv + rv == target) {// ��ǥ���� ���������Ƿ�
				int lc = 0;
				int rc = 0;
				while (leftIdx < AList.size() && AList.get(leftIdx) == lv) {
					lc++;
					leftIdx++;
				}
				while (rightIdx >= 0 && BList.get(rightIdx) == rv) {
					rc++;
					rightIdx--;
				}
				ans += lc * rc;
			}
			if (lv + rv > target)
				rightIdx--;
			if (lv + rv < target)
				leftIdx++;

		}
		System.out.println(ans);
	}

	private static void getSum(int sum, int startIdx, int idx, boolean[] check, int[] arr, ArrayList<Integer> list) {

		if (idx == arr.length) {
			idx = 0;
		}
		list.add(sum);
		// ���� �ȴ��� ���� ���ǿ����ؼ��� && ��ȯ ������.
		if (check[idx] == false && sum <= target && idx != startIdx - 1) {
			check[idx] = true;
			getSum(sum + arr[idx], startIdx, idx + 1, check, arr, list);
		} else {
			return;
		}

	}
}
