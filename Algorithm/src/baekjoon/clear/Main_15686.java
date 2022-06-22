package baekjoon.clear;

import java.util.*;

class Dot {
	int x;
	int y;

	Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_15686 {
	static int N;
	static int M;
	static int[][] arr;
	static ArrayList<Dot> chicken;
	static ArrayList<Dot> person;
	static int[] output;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][N];
		result = Integer.MAX_VALUE;
		chicken = new ArrayList<Dot>();
		person = new ArrayList<Dot>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 1) {
					// 1�϶��� ��� list�� �߰�
					person.add(new Dot(i, j));
				} else if (arr[i][j] == 2) {
					// 2�϶��� ġŲ list�� �߰�
					chicken.add(new Dot(i, j));
				}
			}
		}

		// ġŲ �� ������ ���� �迭 visited, output
		visited = new boolean[chicken.size()];
		output = new int[chicken.size()];

		// ġŲ �� ����
		for (int i = 0; i < chicken.size(); i++) {
			visited[i] = true;
			ChickenSelection(i, 0);
			visited[i] = false;
		}
		System.out.println(result);
	}

	// ġŲ�� ������ ���� �Լ�
	public static void ChickenSelection(int start, int depth) {
		output[depth] = start + 1;

		for (int i = start; i < chicken.size(); i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			ChickenSelection(i, depth + 1);
			visited[i] = false;
		}
		// ġŲ���� ���õǾ��� ���
		// (ġŲ���� �ִ� M�� �̹Ƿ� depth�� M-1 �� �Ǿ���Ѵ�. 0���� ���������ϱ�)
		if (depth == M - 1) {
			int sum = 0;
			int currentM = 0;
			// ����� ���� �ִ� ġŲ���� ����� ���� �ּҰ��� �����Ѵ�.
			// person �Ѹ� ��� Chicken ���� �����Ͽ� �ּҰ��� ���Ѵ�.
			for (int i = 0; i < person.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					currentM = Calc(person.get(i), chicken.get(output[j] - 1));
					min = Math.min(min, currentM);
				}
				// �ּҰ��� ��� ���Ѵ�.
				sum = sum + min;
			}
			// ġŲ�� ����� ������ �ٸ� �ּҰŸ��� ���� ���� �ּҰŸ��� �����Ѵ�.
			result = Math.min(result, sum);
		}
	}

	// ��ġ �Ÿ� ��� �Լ�
	public static int Calc(Dot d1, Dot d2) {
		return Math.abs(d1.x - d2.x) + Math.abs(d1.y - d2.y);
	}
}
