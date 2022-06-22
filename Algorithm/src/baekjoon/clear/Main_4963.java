package baekjoon.clear;

import java.util.Scanner;

public class Main_4963 {
	static int w, h;
    static int[][] island;
    static int[][] visit;
    static int[] col = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] row = {1, -1, 0 , 0 ,1, 1, -1, -1};
    //��, �Ʒ�, ��, ��, ������(���� �� �밢��), ������, �޾ƴ�, ���ƴ�
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			
			island = new int[h][w];
			visit = new int[h][w];
			
			int result = 0;
			
			if(w == 0 && h == 0) 
				break;
			
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					island[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(visit[i][j] == 0 && island[i][j] == 1) {
						dfs(i, j);
						result++;
					}
				}
			}
			
			System.out.println(result);
		}
	}
	
	static void dfs(int x, int y)
    {
		visit[x][y] = 1;
        
        for (int i = 0; i < 8; i++) {
        	int next_row = x + row[i];
        	int next_col = y + col[i];
        	
        	if(next_row < 0 || next_row >= h || next_col < 0 || next_col >= w) {
        		continue;//break�� �Ұ�
        	}
        	if(island[next_row][next_col] == 1 && visit[next_row][next_col] == 0) {
        		dfs(next_row, next_col);
        	}
        }
    }

}
