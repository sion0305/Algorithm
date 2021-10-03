package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1753 {

	public static final int INF = (int) 1e9;

	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

	public static int[] d = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int v = sc.nextInt();
		int e = sc.nextInt();

		int k = sc.nextInt();

		// 그래프 초기화
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<Node>());
		}

		// 모든 간선 정보를 입력받기
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			// a번 노드에서 b번 노드로 가는 비용이 c라는 의미
			graph.get(a).add(new Node(b, c));
		}

		// 최단 거리 테이블을 모두 무한으로 초기화
		Arrays.fill(d, INF);

		// 다익스트라 알고리즘을 수행
		dijkstra(k);

		// 모든 노드로 가기 위한 최단 거리를 출력
		for (int i = 1; i <= v; i++) {
			// 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
			if (d[i] == INF) {
				System.out.println("INF");
			}
			// 도달할 수 있는 경우 거리를 출력
			else {
				System.out.println(d[i]);
			}
		}
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.distance;
			int now = node.index;

			if (d[now] < dist)
				continue;

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
