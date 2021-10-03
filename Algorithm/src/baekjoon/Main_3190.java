package baekjoon;

import java.util.*;

public class Main_3190 {

	static int count = 0, n;
	static List<int[]> q = new LinkedList<>();
	static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		int k = sc.nextInt();

		Map<Integer, String> map = new HashMap<>();

		int[][] board = new int[n + 1][n + 1];
		for (int i = 0; i < k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			board[a][b] = 1;
		}

		int l = sc.nextInt();
		for (int i = 0; i < l; i++) {
			int x = sc.nextInt();
			String c = sc.next();

			map.put(x, c);
		}

		int x = 0, y = 0;
		int dir = 0;
		q.add(new int[] { 1, 1 });

		while (true) {

			count++;
//			int[] p = q.poll();
			int[] p = q.get(q.size() - 1);

			x = p[0] + dirs[dir][0];
			y = p[1] + dirs[dir][1];

			if (isFinished(x, y))
				break;

			if (board[x][y] == 1) {
				board[x][y] = 0;
				q.add(new int[] { x, y }); // 머리정보추가
			} else {
				q.add(new int[] { x, y });// 위치 이동
//				q.poll();//꼬리 빼기
				q.remove(0);
			}

			if (map.containsKey(count)) {
				if (map.get(count).equals("D")) {
					dir++;
					if (dir == 4)
						dir = 0;
				}
				if (map.get(count).equals("L")) {
					dir--;
					if (dir == -1)
						dir = 3;
				}
			}
		}

		System.out.println(count);
	}

	public static boolean isFinished(int x, int y) {
		if (x < 1 || x > n || y < 1 || y > n)
			return true;

//		for(int i=0; i<q.size(); i++) {
//			int[] p = q.poll();
//			if(x == p[0] && y == p[1]) 
//				return true;
//			q.add(p);
//		}

		// 자기 몸통에 닿거나
		for (int i = 0; i < q.size(); i++) {
			if (x == q.get(i)[0] && y == q.get(i)[1])
				return true;
		}

		return false;
	}
}
