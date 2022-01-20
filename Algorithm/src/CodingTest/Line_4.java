package CodingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Line_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] needs = { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int r = 2;
		

		String s = "AABAAA";
		s = s.replaceFirst("AAB", "");
		
		System.out.println(s);

//		solution(needs, r);
	}
	

	static int pSize;
	static int cSize;

	static int max = 0;
	static boolean[] visited;
	static int[] temp;

	public static int solution(int[][] needs, int r) {
		int answer = 0;

		pSize = needs.length;// 완제품개수
		cSize = needs[0].length;// 부품개수
		
		visited = new boolean[cSize];
		temp = new int[r];

		dfs(needs,r, 0);

		return max;
	}

	public static void dfs(int[][] needs, int r, int depth) {
		if (depth == r) {
			checkCount(needs);
			return;
		}

		for (int i = 0; i < cSize; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			temp[depth] = i;
			dfs(needs,r, depth + 1);
			visited[i] = false;
		}
	}

	public static void checkCount(int[][] needs) {
		List<Integer> list = (ArrayList<Integer>) Arrays.stream(temp).boxed().collect(Collectors.toList());
		int count = 0;
		for (int i = 0; i < pSize; i++) {
			boolean can = true;
			for (int j = 0; j < cSize; j++) {
				if (needs[i][j] == 1) {
					if (!list.contains(j)) {
						can = false;
					}
				}
			}
			if (can)
				count++;
		}

		max = Math.max(max, count);
	}

}
