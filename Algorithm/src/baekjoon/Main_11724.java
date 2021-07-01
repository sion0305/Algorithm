package baekjoon;

import java.util.Scanner;

public class Main_11724 {
	static final int MAX_VERTEX = 1001;
	 
    static int map[][] = new int[MAX_VERTEX][MAX_VERTEX];
    static int visit[] = new int[MAX_VERTEX];
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int e = sc.nextInt();
		int result = 0;
		
		for(int i = 0; i < e; i++) {//무방향 그래프
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			map[v1][v2] = map[v2][v1] = 1;
		}
		
		for(int i = 1; i <= n; i++) {
			if(visit[i] == 0) {//방문을 하지 않은 노드부터 시작
				depthFirstSearch(i,n);
				result++;
			}
		}
		
		System.out.println(result);
	}
	
	static void depthFirstSearch(int v, int n)
    {
        visit[v] = 1;//방문함
        for (int i = 1; i <= n; i++)
        {
            if (map[v][i] == 1 && visit[i] == 0)
            {
                depthFirstSearch(i, n);
            }
        }
    }
}
