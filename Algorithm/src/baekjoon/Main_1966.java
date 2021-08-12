package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1966 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		int count;
		
		for(int i = 0; i < tc; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			Queue<int[]> q = new LinkedList<>();
			count = 0;
			for(int j = 0; j < n; j++)
				q.add(new int[] {j, sc.nextInt()});
			
			while(!q.isEmpty()) {
				int[] poll = q.poll();
				boolean able = true;
				for(int[] t : q)
					if(t[1] > poll[1])
						able = false; 
				if (able) { 
					count++; 
					if (poll[0]==m) 
						break; 
				} 
				else q.add(poll);
			}
			System.out.println(count);
		}
	}
}
