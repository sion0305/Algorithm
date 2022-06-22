package baekjoon.clear;

import java.util.HashSet;
import java.util.Scanner;

public class Main_2210 {
	static HashSet<String> hs = new HashSet<>();
	static int[][] map = new int[5][5];
	static int[] col = {-1, 0,0, 1};
    static int[] row = {0, 1, -1, 0};
    static String result="";
    
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
//		HashSet<String> hs = new HashSet<>();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				dfs(i, j, 0, result);
			}
		}
		System.out.println(hs.size());
	}

	static void dfs(int x, int y, int cnt, String result)
    {
        if(cnt == 6) {
        	hs.add(result);
        	System.out.println(result);
    		return;
    	}
        
        for (int i = 0; i < 4; i++) {
        	int next_row = x + row[i];
        	int next_col = y + col[i];
        	
        	if(next_row < 0 || next_row >= 5 || next_col < 0 || next_col >= 5) {
        		continue;//break�� �Ұ�
        	}
        	dfs(next_row, next_col, cnt+1, result+map[x][y]);
        }
    }
}
