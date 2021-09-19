package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_13460 {

	private static int n;
	private static int m;
	static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		char[][] grid = new char[n][m];
		int[] red = null;
		int[] dest = null;
		int[] blue = null;
		
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			grid[i] = s.toCharArray();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == 'O') {
					dest = new int[] {i,j};
				}else if(grid[i][j] == 'R') {
					red = new int[] {i,j};
					grid[i][j] = '.';
				}else if(grid[i][j] == 'B') {
					blue = new int[] {i,j};
					grid[i][j] = '.';
				}
			}
		}
		System.out.println(hasPath(grid, red, dest, blue));
	}
	public static int hasPath(char[][] maze, int[] red, int[] dest, int[] blue) {
		if(red[0] == dest[0] && red[1] == dest[1]) {
			return 0;
		}
		if(blue[0] == dest[0] && blue[1] == dest[1]) {
			return -1;
		}
		
		boolean[][][][] visited = new boolean[n][m][n][m];
		visited[red[0]][red[1]][blue[0]][blue[1]] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {red[0], red[1], blue[0], blue[1],0});
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			if(p[4] > 10) 
				continue;
			
			for(int[] dir : dirs) {
				boolean blueIn = false;
				//blue먼저 이동
				int bx = p[2] + dir[0];
				int by = p[3] + dir[1];
				while(maze[bx][by] != '#') {
					if(bx == dest[0] && by == dest[1]) {
						blueIn = true;
						break;
					}
					//벽을 만날때까지 이동
					bx+=dir[0];
					by+=dir[1];
				}
				//벽만나면 튕겨나와야하니까 전위치로 이동
				bx-=dir[0];
				by-=dir[1];
				
				//red먼저 이동
				int rx = p[0] + dir[0];
				int ry = p[1] + dir[1];
				while(maze[rx][ry] != '#') {
					if(rx == dest[0] && ry == dest[1]) {
						if(blueIn == true)
							return -1;
						return p[4] + 1;
					}
					//벽을 만날때까지 이동
					rx+=dir[0];
					ry+=dir[1];
				}
				//벽만나면 튕겨나와야하니까 전위치로 이동
				rx-=dir[0];
				ry-=dir[1];
				
				//더 많이 이동하는 경우 = 더 늦게 도착
				if(rx == bx && ry == by) {
					int rDist = Math.abs(p[0] - rx) + Math.abs(p[1] - ry);
					int bDist = Math.abs(p[2] - bx) + Math.abs(p[3] - by);
					if(rDist > bDist) {
						rx-=dir[0];
						ry-=dir[1];
					}else {
						bx-=dir[0];
						by-=dir[1];
					}
				}
				
				if(!visited[rx][ry][bx][by]) {
					visited[rx][ry][bx][by] = true;
					queue.offer(new int[] {rx,ry,bx,by,p[4]+1});
				}
			}
		}
		return -1;
	}
}