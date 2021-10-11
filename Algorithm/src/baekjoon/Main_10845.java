package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> q = new LinkedList<>();
				
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			switch(input[0]) {
				case "push":
					q.add(Integer.parseInt(input[1]));
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
