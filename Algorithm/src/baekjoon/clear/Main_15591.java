package baekjoon.clear;

import java.util.*;

public class Main_15591 {

    static class Node {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        ArrayList<Node>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            int r = sc.nextInt();

            graph[p].add(new Node(q, r));
            graph[q].add(new Node(p, r));
        }

        for (int i = 0; i < Q; i++) {
            int K = sc.nextInt();
            int V = sc.nextInt();

            int count = 0;
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];

            visited[V] = true;
            queue.offer(V);

            while (!queue.isEmpty()) {
                int number = queue.poll();
                List<Node> list = graph[number];

                for (int j = 0; j < list.size(); j++) {
                    if (visited[list.get(j).index]) {
                        continue;
                    }

                    if (list.get(j).value < K) {
                        continue;
                    }

                    count++;
                    queue.offer(list.get(j).index);
                    visited[list.get(j).index] = true;
                }
            }
            System.out.println(count);
        }
    }
   
}
