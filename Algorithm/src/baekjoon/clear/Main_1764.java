package baekjoon.clear;

import java.util.*;

public class Main_1764 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		HashSet<String> hs = new HashSet<>();

		for(int i = 0; i < n; i++) {
			hs.add(sc.next());
		}
		
		ArrayList<String> list= new ArrayList<>();
		for(int i = 0; i < m; i++) {
			String s = sc.next();
			if(hs.contains(s)) {
				list.add(s);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(String s : list) {
			System.out.println(s);
		}
	}

}
