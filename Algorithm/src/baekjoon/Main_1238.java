package baekjoon;

import java.util.*;

class Node implements Comparable<Node> {

    int index;
    int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Main_1238 {
	public static final int INF = (int) 1e9;
	public static ArrayList<ArrayList<Node>> list, reverse;
	public static int n,x;
	public static int[] d1, d2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int m = sc.nextInt();
		x = sc.nextInt();
		
		d1 = new int[n+1];
		d2 = new int[n+1];
		
		Arrays.fill(d1, INF);
		Arrays.fill(d2, INF);
		
		list = new ArrayList<>();
		reverse = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			list.get(a).add(new Node(b, c));
			reverse.get(b).add(new Node(a, c));
		}
		
		dijkstra(list, d1, x);
		dijkstra(reverse, d2, x);
		
		int max = -1;
		for(int i = 1; i <= n; i++) {
			max = Math.max(max, d1[i] + d2[i]);
		}
		System.out.println(max);
	}
	
	public static void dijkstra(ArrayList<ArrayList<Node>> list, int[] distance, int start) {
		boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
 
        distance[start] = 0;
 
        while (!pq.isEmpty()) {
            int idx = pq.poll().index;
 
            if (visited[idx]) continue;
            visited[idx] = true;
 
            for (Node node : list.get(idx)) {
                if (distance[node.index] > distance[idx] + node.distance) {
                    distance[node.index] = distance[idx] + node.distance;
                    pq.add(new Node(node.index, distance[node.index]));
                }
            }
        }
    }

}
