package baekjoon;

import java.util.Scanner;

public class Main_10775 {

	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int g = sc.nextInt();
		int p = sc.nextInt();
		
		parent = new int[g + 1];
		for (int i = 1; i <= g; i++) {
			parent[i] = i;
		}
		
		int count = 0;
		for(int i = 0; i < p; i++) {
			int gate = sc.nextInt();
			int emptyGate = find(g);
			
			if(emptyGate == 0) {
				break;
			}
			
			count++;
			union(emptyGate, emptyGate-1);
		}

	}
	
	public static int find(int g) {
		if(g == parent[g]) {
			return g;
		}
		
		return parent[g] = find(parent[g]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[x] = y;
		}
	}
}
