package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1406 { //¹¹¾ß;;;;;;;;;;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		ArrayList<Character> list= new ArrayList<>();
		
		for(int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}
		
		int n = Integer.parseInt(br.readLine());
		
		int cursor = s.length();
		while(n --> 0){
			String[] command = br.readLine().split(" ");
			
			if(command[0].equals("P")) {
				list.add(cursor, command[1].charAt(0));
				cursor += 1;
			}else if(command[0].equals("L")) {
				if(cursor != 0)
					cursor -= 1;
			}else if(command[0].equals("D")) {
				if(cursor != list.size())
					cursor += 1;
			}else {
				if(cursor != 0) {
					list.remove(cursor-1);
					cursor -= 1;
				}
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
	}

}
