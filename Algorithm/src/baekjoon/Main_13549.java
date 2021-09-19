package baekjoon;

import java.util.*;

public class Main_13549 {
    static boolean[] visited = new boolean[100001];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(bfs(n,k));
	}
	 	
	public static int bfs(int n, int k) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.offer(new Point(n,0));
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
            visited[point.pos] = true; //3가지케이스에 큐에 offer한다음에 방문처리하면 우선순위때문에 최소거리 바뀌는 경우 발생함
            
            if (point.pos == k) {
            	return point.count;
            }
            if (point.pos * 2 <= 100000 && !visited[point.pos * 2]) { // 0초 순간이동
                queue.offer(new Point(point.pos * 2, point.count));
            }
            if (point.pos + 1 <= 100000 && !visited[point.pos + 1]) { //1초 한칸우측
                queue.offer(new Point(point.pos + 1, point.count + 1));
            }
            if (point.pos - 1 >= 0 && !visited[point.pos - 1]) { //1초 한칸좌측
                queue.offer(new Point(point.pos - 1, point.count + 1));
            }
		}
		
		return 0;
	}
	
	private static class Point implements Comparable<Point>{
        int pos;
        int count;

        public Point(int pos, int count) {
            this.pos = pos;
            this.count = count;
        }

        @Override
        public int compareTo(Point o) {
            return count - o.count;
        }
    }

}