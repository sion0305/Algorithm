package baekjoon.clear;

import java.io.*;
import java.util.*;

public class Main_11723 {

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		int m = sc.nextInt();
//
//		for (int i = 0; i < m; i++) {
//			String s = sc.next();
//			ArrayList<Integer> arr = new ArrayList<>();
//
//			if (s.equals("all")) {
//				List<Integer> change = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
//						20);
//				arr = (ArrayList<Integer>) change;
//			} else if (s.equals("empty")) {
//				arr = new ArrayList<>();
//			} else {
//				String[] split = s.split(" ");
//				int x = Integer.parseInt(split[1]);
//				if (split[0].equals("add")) {
//					arr.add(x);
//				} else if (split[0].equals("remove")) {
//					arr.remove(x);
//				} else if (split[0].equals("check")) {
//					if (arr.contains(x)) {
//						System.out.println(1);
//					} else {
//						System.out.println(0);
//					}
//				} else if (split[0].equals("toggle")) {
//					if (arr.contains(x)) {
//						arr.remove(x);
//					} else {
//						arr.add(x);
//					}
//				}
//			}
//		}
//
//	}
	
	 public static void main(String args[]) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        StringBuilder sb = new StringBuilder();
	        int M = Integer.parseInt(br.readLine());
	        int bitMask =0;
	        while(M-- >0){
	            String s = br.readLine();
	            StringTokenizer st = new StringTokenizer(s," ");
	            String op = st.nextToken();
	            int n;

	            switch (op){
	                case "add":
	                    n = Integer.parseInt(st.nextToken());
	                    bitMask = bitMask | 1<<(n-1);
	                    break;

	                case "remove":
	                    n = Integer.parseInt(st.nextToken());
	                    bitMask = bitMask & ~(1<<(n-1));
	                    break;

	                case "check":
	                    n = Integer.parseInt(st.nextToken());
	                    sb.append(((bitMask & 1<<(n-1)) == 1<<(n-1) ? 1:0)+"\n");
	                    break;

	                case "toggle":
	                    n = Integer.parseInt(st.nextToken());
	                    bitMask = bitMask ^ 1<<(n-1);
	                    break;

	                case "all":
	                    bitMask = ~0;
	                    break;

	                case "empty":
	                    bitMask = 0;
	                    break;

	            }
	        }
	        bw.write(sb.toString());
	        bw.close();
	        br.close();

	    }

}
