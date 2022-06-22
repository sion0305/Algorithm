package baekjoon.clear;

import java.util.*;

public class Main_10815 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		HashSet<Integer> hs = new HashSet<>();

		for(int i = 0; i < n; i++) {
			hs.add(sc.nextInt());
		}
		
		int m = sc.nextInt();
		int[] result = new int[m];
		
		for(int i = 0; i < m; i++) {
			int check = sc.nextInt();
			
			if(hs.contains(check)) {
				result[i] = 1;
			}else {
				result[i] = 0;
			}
		}
		
		for(int r : result) {
			System.out.print(r + " ");
		}
	}

}
