package baekjoon;

import java.util.Scanner;

public class Main_2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();

		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char check = s.charAt(i);
			if (check == 'c') {
				if (i < s.length() - 1) {
					if (s.charAt(i + 1) == '-') {
						i++;
					} else if (s.charAt(i + 1) == '=') {
						i++;
					}
				}
			} else if (check == 'd') {
				if (i < s.length() - 1) {
					if (s.charAt(i + 1) == '-') {
						i++;
					} else if (s.charAt(i + 1) == 'z') {
						if (i < s.length() - 2) {
							if (s.charAt(i + 2) == '=') {
								i += 2;
							}
						}
					}
				}
			} else if (check == 'l') {
				if (i < s.length() - 1) {
					if (s.charAt(i + 1) == 'j') {
						i++;
					}
				}
			} else if (check == 'n') {
				if (i < s.length() - 1) {
					if (s.charAt(i + 1) == 'j') {
						i++;
					}
				}

			} else if (check == 's') {
				if (i < s.length() - 1) {
					if (s.charAt(i + 1) == '=') {
						i++;
					}
				}
			} else if (check == 'z') {
				if (i < s.length() - 1) {
					if (s.charAt(i + 1) == '=') {
						i++;
					}
				}
			}
			count++;
		}
		System.out.println(count);
	}
}
