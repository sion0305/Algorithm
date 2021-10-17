package baekjoon;

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
	// ㅗ 모양 제외 모든 모양
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
		int wing = 4;    // 가운데에서의 상하좌우 날개
        int min = Integer.MAX_VALUE;
        int sum = map[x][y];
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
 
            //날개가 2개이상 없다면 ㅗ 모양이 아니다. 그러므로 함수를 종료한다.
            if (wing <= 2)
                return;
            //날개가 맵 바깥에 있다면 날개가 아니다.
            if (newX < 0 || newY < 0 || newX >= n || newY >= m) {
                wing--;
                continue;
            }
            min = Math.min(min, map[newX][newY]);
            sum = sum + map[newX][newY];
        }
        //날개가 4개일때 가장 작은 날개를 없애야 ㅗ,ㅏ,ㅓ,ㅜ 모양이 나온다.
        if (wing == 4) {
            sum = sum - min;
        }
        max = Math.max(max, sum);
    }

}
