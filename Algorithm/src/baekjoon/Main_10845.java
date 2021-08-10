package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_10845 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		LinkedList<Integer> q = new LinkedList<>();
				
		for(int i = 0; i < num; i++) {
			String input = sc.next();
			switch(input) {
				case "push":
					int n = sc.nextInt();
					q.add(n);
					break;
				case "pop":
					if(q.isEmpty()) {
						System.out.println(-1);
					}else {
						System.out.println(q.removeFirst());
					}
					break;
				case "size":
					System.out.println(q.size());
					break;
				case "empty":
					if(q.isEmpty()) {
						System.out.println(1);
					}else {
						System.out.println(0);
					}
					break;
				case "front":
					if(q.isEmpty()) {
						System.out.println(-1);
					}else {
						System.out.println(q.getFirst());
					}
					break;
				case "back":
					if(q.isEmpty()) {
						System.out.println(-1);
					}else {
						System.out.println(q.getLast());
					}
					break;
			}
		}
	}
}
