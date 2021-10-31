package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_15683 {
	static final int CAM = 10;
	static int[][] dirs = {{-1,0}, {0,1}, {-1,0},{0,-1}};
	static int n, m, min;
	static int[][] map;
	static ArrayList<int[]> cctv = new ArrayList<>();
	static boolean[][] visited = new boolean[10][5];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n+2][m+2];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				
				if (1 <= map[i][j] && map[i][j] <= 5)
                    cctv.add(new int[] {i, j, map[i][j], getDirection(map[i][j])});
			}
		}
		
		dfs(0);
		
		System.out.println(min);
	}
	
	public static void dfs(int depth) {
        if (depth == cctv.size()) {
        	min = Math.min(min, getDeadGround());
            return;
        }
 
        for (int i = 0; i < cctv.get(depth)[3]; i++) {
            if (visited[depth][i]) continue;
            visited[depth][i] = true;
            install(cctv.get(depth)[0], cctv.get(depth)[1], cctv.get(depth)[2], i, CAM);
            dfs(depth + 1);
            visited[depth][i] = false;
            install(cctv.get(depth)[0], cctv.get(depth)[1], cctv.get(depth)[2], i, -CAM);
        }
    }
	
	public static int getDeadGround() {
        int sum = 0;
 
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (map[i][j] == 0) sum++;
 
        return sum;
    }
	
	public static void install(int x, int y, int cam, int d, int status) {
        changeStatus(x, y, d, status);
        if (cam == 3 || cam == 4 || cam == 5)
            changeStatus(x, y, d + 1, status);
        if (cam == 2 || cam == 4 || cam == 5)
            changeStatus(x, y, d + 2, status);
        if (cam == 5)
            changeStatus(x, y, d + 3, status);
    }
	
	public static void changeStatus(int x, int y, int d, int status) {
        d %= 4;
        // p: prev, n: next
        int px = x, py = y, nx, ny;
        while(true) {
            nx = px + dirs[d][0];
            ny = py + dirs[d][1];
 
            if (x < 1 || x > n || y < 1 || y > m || map[x][y] == 6) break;
 
            map[nx][ny] += status;
            px = nx;
            py = ny;
        }
    }
	
	public static int getDirection(int d) {
        int direction = 0;
 
        switch(d) {
        case 1:
        case 3:
        case 4:
            direction = 4;
            break;
        case 2:
            direction = 2;
            break;
        case 5:
            direction = 1;
            break;
        }
 
        return direction;
    }

}
