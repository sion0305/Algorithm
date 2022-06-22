package baekjoon.clear;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697 {
	static int[] visit = new int[100001]; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(solution(n,k));

	}
	public static int solution(int n, int k) {
		if(n == k ) return 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visit[n] =  1;
		
		while(!q.isEmpty()) {
			int p = q.poll();
			
			for(int i = 0; i < 3; i++) {
				int tmp;
				if(i == 0) {
					tmp = p + 1;
				}else if(i == 1) {
					tmp = p - 1;
				}else {
					tmp = p * 2;
				}
				
				if(tmp == k) {
					return visit[p];
				}
				
				if(tmp >= 0 && tmp < visit.length && visit[tmp] == 0) {
					q.add(tmp);
					visit[tmp] = visit[p] + 1;
				}
			}
		}
		return -1;
	}
}
