package baekjoon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1202 {//º¸¼® µµµÏ

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Jewel[] jewel = new Jewel[n];
		int[] bag = new int[k];
		
		for(int i = 0; i < n; i++) {
			int m = sc.nextInt();
			int v = sc.nextInt();
			
			jewel[i] = new Jewel(m,v);
		}
		
		for(int i = 0; i < k; i++) {
			bag[i] = sc.nextInt();
		}
		
		Arrays.sort(jewel);
		Arrays.sort(bag);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		long sum = 0;
		int idx = 0;
		
		for(int i = 0; i < k; i++) {
			while(idx < n && jewel[idx].m <= bag[i]) {
				pq.offer(-jewel[idx++].v);
			}
			
			if(!pq.isEmpty()) {
				sum += Math.abs(pq.poll());
			}
		}
		
		System.out.println(sum);
	}

	static class Jewel implements Comparable<Jewel>{
		int m;
		int v;
		
		public Jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Jewel o) {
			return this.m - o.m;
		}
	}
}
