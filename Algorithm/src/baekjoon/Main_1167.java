package baekjoon;

import java.util.*;

public class Main_1167 {

	public static ArrayList<Node>[] list;
	public static boolean[] visited;
	static int max = 0;
	static int node = 0;
	static int v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		v = sc.nextInt();
		
		list = new ArrayList[v+1];
		for(int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < v; i++) {
			int s = sc.nextInt();
			
			while(true) {
				int e = sc.nextInt();
				if(e == -1) break;
				int cost = sc.nextInt();
				
				list[s].add(new Node(e, cost));
			}
		}
		
		visited = new boolean[v+1];
		dfs(1,0);
		
		visited = new boolean[v+1];
		dfs(node, 0);
		
		System.out.println(max);
		
	}
	
	public static void dfs(int x, int len) {
		if(len > max) {
			max = len;
			node = x;
		}
		visited[x] = true;
		
		for(int i = 0; i < list[x].size(); i++) {
            Node n = list[x].get(i);
            if(visited[n.e] == false) {
                dfs(n.e, n.cost + len);
                visited[n.e] = true;
            }
        }
	}

	public static class Node{
		int e;
		int cost;
		
		public Node(int e, int cost) {
			this.e = e;
			this.cost = cost;
		}
	}

}
