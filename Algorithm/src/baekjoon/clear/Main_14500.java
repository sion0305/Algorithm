package baekjoon.clear;

import java.util.Scanner;

public class Main_14500 {
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int max;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j< m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				dfs(i,j,0,0);
				exception(i,j);
			}
		}
		
		System.out.println(max);
	}
	// �� ��� ���� ��� ���
	public static void dfs(int x, int y, int depth, int sum) {
		if(depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
 
            if (newX < 0 || newY < 0 || newX >= n || newY >= m || visited[newX][newY]) {
                continue;
            }
            
            visited[newX][newY] = true;
            dfs(newX, newY, depth + 1, sum + map[newX][newY]);
            visited[newX][newY] = false;
 
        }
	}
	
	public static void exception(int x, int y) {
		int wing = 4;    // ��������� �����¿� ����
        int min = Integer.MAX_VALUE;
        int sum = map[x][y];
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
 
            //������ 2���̻� ���ٸ� �� ����� �ƴϴ�. �׷��Ƿ� �Լ��� �����Ѵ�.
            if (wing <= 2)
                return;
            //������ �� �ٱ��� �ִٸ� ������ �ƴϴ�.
            if (newX < 0 || newY < 0 || newX >= n || newY >= m) {
                wing--;
                continue;
            }
            min = Math.min(min, map[newX][newY]);
            sum = sum + map[newX][newY];
        }
        //������ 4���϶� ���� ���� ������ ���־� ��,��,��,�� ����� ���´�.
        if (wing == 4) {
            sum = sum - min;
        }
        max = Math.max(max, sum);
    }

}
