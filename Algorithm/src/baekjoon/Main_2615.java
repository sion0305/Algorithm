package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2615 {
	static int[] dx = {1, 0, 1, -1};
    static int[] dy = {1, 1, 0, 1};
	static int[][] board = new int[19][19];;
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(board[i][j] != 0) {
					for(int k=0; k<4; k++) {
                        int cnt = bfs(i, j, k);

                        if(cnt==5) {
                            System.out.println(board[i][j]);
                            System.out.println((i+1)+" "+(j+1));
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    public static int bfs(int x, int y, int idx) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y, 1));
        int max = 0;

        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            max = Math.max(temp.cnt, max);

            int nx = temp.x+dx[idx];
            int ny = temp.y+dy[idx];

            if(nx<0 || nx>=19 || ny<0 || ny>=19 || board[nx][ny]!=board[temp.x][temp.y]) continue;

            queue.add(new Pair(nx, ny, temp.cnt+1));
        }

        if(max==5) {
            int nx = x-dx[idx];
            int ny = y-dy[idx];

            if(nx>=0 && nx<19 && ny>=0 && ny<19 && board[nx][ny]==board[x][y])
                max++;
        }

        return max;
    }

    public static class Pair {
        int x;
        int y;
        int cnt;

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
//	static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
//	static int[][] board = new int[19][19];;
//	public static void main(String[] args) {
//		Scanner sc  = new Scanner(System.in);
//		
//		for(int i = 0; i < 19; i++) {
//			for(int j = 0; j < 19; j++) {
//				board[i][j] = sc.nextInt();
//			}
//		}
//
//		for(int i = 0; i < 19; i++) {
//			for(int j = 0; j < 19; j++) {
//				if(board[i][j] != 0) {
//					int count = solution(i,j);
//					
//					if(count == 5) {
//						System.out.println(board[i][j]);
//						System.out.println((i-1) + " " + (j-1));
//						return;
//					}
//				}
//			}
//		}
//		System.out.println(0);
//	}
//
//	public static int solution(int x, int y) {
////		Queue<int[]> q = new LinkedList<>();
//		Queue<Pair> q = new LinkedList<>();
////		q.add(new int[] {x,y,1});
//		q.add(new Pair(x,y,1));
//		
//		int max = 0;
//		
//		while(!q.isEmpty()) {
////			int[] p = q.poll();
//			Pair p = q.poll();
////			max = Math.max(p[2], max);
//			max = Math.max(p.cnt, max);
//			
//			for(int[] d : dirs) {
////				int nx = p[0] + d[0];
////				int ny = p[1] + d[1];
//				int nx = p.x + d[0];
//				int ny = p.y + d[1];
//				
////				if(nx<0 || nx>=19 || ny<0 || ny>=19 || board[nx][ny] != board[p[0]][p[1]]) continue;
//				if(nx<0 || nx>=19 || ny<0 || ny>=19 || board[nx][ny] != board[p.x][p.y]) continue;
//				
////				q.add(new int[] {nx,ny, p[2] + 1});
//				q.add(new Pair(nx,ny,p.cnt + 1));
//				
//			}
//		}
//		
//		if(max == 5) {
//			for(int[] d : dirs) {
//				int nx = x - d[0];
//				int ny = y - d[1];
//				
//				if(nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && board[nx][ny] == board[x][y])
//					max++;
//			}
//		}
//		
//		return max;
//	}
//	
//	public static class Pair {
//        int x;
//        int y;
//        int cnt;
//
//        public Pair(int x, int y, int cnt) {
//            this.x = x;
//            this.y = y;
//            this.cnt = cnt;
//        }
//    }
}
