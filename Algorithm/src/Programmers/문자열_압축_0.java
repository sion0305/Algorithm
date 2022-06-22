package Programmers;

public class 문자열_압축_0 {// 2021 kakao

	// self -> ����(42.0) -> ����
	public static void main(String[] args) {
//		String s = "aabbaccc";
//		String s = "ababcdcdababcdcd";
		String s = "abcabcdede";

		System.out.println(solution(s));

	}

	public static int solution(String s) {
		int answer = s.length();

		int size = s.length();

		String cut1 = s, cut2 = s;
		for (int i = 1; i <= size; i++) {
			cut1 = s.substring(0, i);
			int count = 1;
			StringBuffer comp = new StringBuffer();
			for (int j = i; j < size; j += i) {
				//����
				if(j + i > size) {
					cut2 = s.substring(j);
				}else {
					cut2 = s.substring(j, j + i);
				}
				//����
				
				if (cut1.equals(cut2)) {
					count++;
				} else {
					if (count > 1) {
						comp.append(count + cut1);
					} else {
						comp.append(cut1);
					}

					cut1 = cut2;
					count = 1;
				}
			}
			if (count > 1) {
				comp.append(count + cut1);
			} else {
				comp.append(cut1);
			}

			answer = Math.min(answer, comp.length());
		}

		return answer;
	}
}
