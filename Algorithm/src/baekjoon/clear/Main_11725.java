package baekjoon.clear;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11725 {
	static ArrayList<Integer>[] tree;
	static int[] visit;
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		tree = new ArrayList[n+1];
		visit = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n -1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		solution(1);

		for(int i = 2; i <= n; i++) {
			System.out.println(visit[i]);
		}
	}

	public static void solution(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int p = q.poll();
			for(int i : tree[p]) {
				if(visit[i] == 0) {
					visit[i] = p;
					q.offer(i);
				}
			}
		}
	}
}
