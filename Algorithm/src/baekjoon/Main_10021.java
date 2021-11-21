package baekjoon;

import java.util.*;

public class Main_10021 {

	private static int N;
    private static int C;
    private static int[] x;
    private static int[] y;
    private static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        C = sc.nextInt();

        x = new int[N];
        y = new int[N];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> (int) (o1.value - o2.value));

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                long dist = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);

                queue.offer(new Node(i, j, dist));
            }
        }

        int sum = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.value < C) {
                continue;
            }

            int x = node.start;
            int y = node.end;

            if (!isSameParent(x, y)) {
                sum += node.value;
                union(x, y);
                count++;
            }

            if (count == N - 1) {
                break;
            }
        }

        if (count != N - 1) {
            System.out.println(-1);

            return;
        }

        System.out.println(sum);
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return true;
        }

        return false;
    }

    static class Node {
        private int start;
        private int end;
        private long value;

        public Node(int start, int end, long value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}