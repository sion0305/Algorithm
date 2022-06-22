package baekjoon.clear;

import java.util.*;

public class Main_9093 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			String[] array = str.split(" ");

			for (int j = 0; j < array.length; j++) {
				sb.append(new StringBuffer(array[j]).reverse().toString() + " ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
		sc.close();
	}
}
