package baekjoon;

import java.util.Scanner;

public class Main_9466 {
	public static int[] pick;
	public static boolean[] visited;
    public static boolean[] finished;
    public static int count;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			int n = sc.nextInt();
			
			pick = new int[n+1];
			
			for(int i = 1; i <= n; i++) {
				pick[i] = sc.nextInt();
			}
			
			visited = new boolean[n+1];
			finished = new boolean[n+1];
			
			count = 0;	//±î¸ÔÁö¸»ÀÚ
			
			for(int i = 1; i <= n; i++) {
				if(!finished[i]) dfs(i);
			}
			
			System.out.println(n-count);
		}
	}

	public static void dfs(int node){
		if (visited[node]) {
            finished[node] = true;
            count++;
        } else {
        	visited[node] = true;
        }

        int next = pick[node];

        if (!finished[next]) {
            dfs(next);
        }

        visited[node] = false;
        finished[node] = true;
    }
}
