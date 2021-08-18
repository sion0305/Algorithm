package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1759 {
	static String[] words;
	static int l, c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		l = sc.nextInt();
		c = sc.nextInt();
		
		words = new String[c];
		for(int i = 0; i < c; i++) {
			words[i] = sc.next();
		}
		
		Arrays.sort(words);
		
		solution(0,"");
	}
	public static void solution(int idx, String str) {
		if(str.length() == l) {
			if(isPossible(str)) {
				System.out.println(str);
			}
			return;
		}
		if(idx >= c) return;
		
		solution(idx + 1, str + words[idx]);
		solution(idx + 1, str);
		
	}
	
	public static boolean isPossible(String str) {
		int vowel = 0;
		for(int i = 0 ; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o') {
				vowel++;
			}
		}
		
		if(vowel >= 1 && str.length() - vowel >= 2) 
			return true;
		
		return false;
	}
}
