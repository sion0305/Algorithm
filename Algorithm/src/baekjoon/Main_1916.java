package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

import baekjoon.Main_1753.Node;

public class Main_1916 {
	public static final int INF = (int) 1e9;

	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

	public static int[] d = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		// 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            graph.get(a).add(new Node(b, c));
		}
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
        Arrays.fill(d, INF);
        
        dijkstra(start);
        
        System.out.println(d[end]);
	}
	
	public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()) { 
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index; 
            
            if (d[now] < dist) continue;
            
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;
                if (cost < d[graph.get(now).get(i).index]) {
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }
	
	public static class Node implements Comparable<Node> {

	    private int index;
	    private int distance;

	    public Node(int index, int distance) {
	        this.index = index;
	        this.distance = distance;
	    }

	    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
	    @Override
	    public int compareTo(Node other) {
	        if (this.distance < other.distance) {
	            return -1;
	        }
	        return 1;
	    }
	}

}
