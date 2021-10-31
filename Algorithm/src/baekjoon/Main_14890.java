package baekjoon;

import java.util.Scanner;

public class Main_14890 {
	static int n, l;
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		
		n = sc.nextInt();
		l = sc.nextInt();
		
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(check(i, 0)) {
				count++;
			}
			
			if(check(i, 1)) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	public static boolean check(int x, int dir) {
		boolean[] visited = new boolean[n];
		int[] tmp = new int[n];
		
		for(int i = 0; i < n; i++) {
			tmp[i] = (dir == 0) ? map[x][i] : map[i][x]; 
		}
		
		for(int i = 0; i < n-1; i++) {
			if(tmp[i] == tmp[i+1]) continue;
			
			if(Math.abs(tmp[i] - tmp[i+1]) > 1) return false;
			
			if(tmp[i] == tmp[i+1] + 1) {
				for(int j = i+1; j <= i + l; j++) {
					if(j >= n || visited[j] || tmp[i+1] != tmp[j])
						return false;
					
					visited[j] = true;
				}
			}else if(tmp[i] == tmp[i+1] - 1) {
				for(int j = i; j > i-l; j--) {
					if(j < 0 || visited[j] || tmp[i] != tmp[j]) 
						return false;
					
					visited[j] = true;
				}
			}
		}
		
		return true;
	}

}
