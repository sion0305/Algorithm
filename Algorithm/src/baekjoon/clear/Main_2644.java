package baekjoon.clear;

import java.util.Scanner;

public class Main_2644 {
	static final int MAX_VERTEX = 101;
	 
	static int result = 0;
    static int map[][] = new int[MAX_VERTEX][MAX_VERTEX];
    static int visit[] = new int[MAX_VERTEX];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int e = sc.nextInt();
		
		for(int i = 0; i < e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x][y] = map[y][x] = 1;
		}
		
		dfs(a, b, num, 0);
		System.out.println(result);
	}
	
	static void dfs(int x, int y, int n, int cnt)
    {
        visit[x] = 1;
        for (int i = 1; i <= n; i++)
        {
            if (map[x][i] == 1 && visit[i] == 0)
            {
            	if(i == y) {
            		result = cnt;
            		break;
            	}
            	else{
            		dfs(i, y, n, cnt+1);
            	}
            }
        }
    }
}
