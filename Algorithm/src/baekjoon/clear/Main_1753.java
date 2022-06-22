package baekjoon.clear;

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

		// �׷��� �ʱ�ȭ
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<Node>());
		}

		// ��� ���� ������ �Է¹ޱ�
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			// a�� ��忡�� b�� ���� ���� ����� c��� �ǹ�
			graph.get(a).add(new Node(b, c));
		}

		// �ִ� �Ÿ� ���̺��� ��� �������� �ʱ�ȭ
		Arrays.fill(d, INF);

		// ���ͽ�Ʈ�� �˰����� ����
		dijkstra(k);

		// ��� ���� ���� ���� �ִ� �Ÿ��� ���
		for (int i = 1; i <= v; i++) {
			// ������ �� ���� ���, ����(INFINITY)�̶�� ���
			if (d[i] == INF) {
				System.out.println("INF");
			}
			// ������ �� �ִ� ��� �Ÿ��� ���
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

		// �Ÿ�(���)�� ª�� ���� ���� �켱������ �������� ����
		@Override
		public int compareTo(Node other) {
			if (this.distance < other.distance) {
				return -1;
			}
			return 1;
		}
	}

}
