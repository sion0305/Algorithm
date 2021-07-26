package baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main_1700 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] elect = new int[k];
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < k; i++) {
			elect[i] = sc.nextInt();
			hm.put(elect[i], hm.getOrDefault(elect[i], 0) + 1);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for(int i = 0; i < k; i++) {
			if(!list.contains(elect[i])) {
				if(list.size() == n) {
					int remove = hm.get(list.get(0)) > hm.get(list.get(1)) ? 1 : 0;
//					System.out.println(list.get(remove));
					list.remove(remove);
					count++;
					
				}
				list.add(elect[i]);
				hm.replace(elect[i], hm.get(elect[i]) - 1);
//				System.out.println(list);
			}
		}
		
		System.out.println(count);
	}

}
