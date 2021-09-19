package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1956 {
	public static final int INF = (int) 1e9;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		int[][] map = new int[v + 1][v + 1];
		
		for(int i = 0; i <= v; i++)
            Arrays.fill(map[i], INF);
		
		for(int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int c = sc.nextInt();
			
			map[a][b] = c;
		}
		
		for (int k = 1; k <= v; k++) {
            for (int a = 1; a <= v; a++) {
                for (int b = 1; b <= v; b++) {
                	map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                }
            }
        }
		
		int answer = INF;
		for(int i = 1; i <= v; i++) {
			answer = Math.min(answer, map[i][i]);
		}
		
		if(answer == INF) System.out.println(-1);
		else System.out.println(answer);
	}

}
