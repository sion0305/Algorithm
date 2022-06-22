package baekjoon.clear;

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
            visited[point.pos] = true; //3�������̽��� ť�� offer�Ѵ����� �湮ó���ϸ� �켱���������� �ּҰŸ� �ٲ�� ��� �߻���
            
            if (point.pos == k) {
            	return point.count;
            }
            if (point.pos * 2 <= 100000 && !visited[point.pos * 2]) { // 0�� �����̵�
                queue.offer(new Point(point.pos * 2, point.count));
            }
            if (point.pos + 1 <= 100000 && !visited[point.pos + 1]) { //1�� ��ĭ����
                queue.offer(new Point(point.pos + 1, point.count + 1));
            }
            if (point.pos - 1 >= 0 && !visited[point.pos - 1]) { //1�� ��ĭ����
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