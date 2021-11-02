package baekjoon;

import java.util.Scanner;

public class Main_15684 {
	static int[][] map;
	static int n,m,h, ans;
	static boolean flag = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		h = sc.nextInt();
		
		map = new int[h+1][n+1];
		
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
			map[x][y+1] = 2;
		}
		
		for(int i = 0; i <= 3; i++) {
			ans = i;
			dfs(1,1,0);
			if(flag) break;
		}
		
		System.out.println(flag?ans:-1);
		
	}
	
	public static void dfs(int x, int y, int count) {
		if(flag) return;
		if(count == ans) {
			if(check()) flag = true;
			return;
		}
		
		for(int i = y; i <= h; i++) {
			for(int j = x; j < n; j++) {
				if(map[i][j] == 0 && map[i][j+1] == 0) {
					map[i][j] = 1;
					map[i][j+1] = 2;
					dfs(1,1,count+1);
					map[i][j] = 0;
					map[i][j+1] = 0;
				}
			}
		}
	}
	
	private static boolean check() {
        for (int i = 1; i <= n; i++) {
            int nx = i;
            int ny = 1;
 
            while (ny <= h) {
                if (map[ny][nx] == 1) nx++; // 우측으로 이동
                else if (map[ny][nx] == 2) nx--; // 좌측으로 이동
                ny++; // y축+1칸 이동한다. (아래로 이동)
            }
 
            if (nx != i) return false; // i번으로 출발해서 i번으로 도착하지 않는게 하나라도 있다면 리턴.
        }
 
        return true;
    }
}