package CodingTest;

import java.util.*;

public class Wadiz_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] code = { "a=3", "..a=4", "..b=3", "..print a", ".......a=6", ".......print a", ".......print b",
				"..print a", "....a=7", "....print a", "print a", "print b", "a=4", "print a", "...print a" };

		String[] answer = solution(code);
		
		for(String s : answer) {
			System.out.println(s);
		}
	}

	public static String[] solution(String[] code) {
		ArrayList<String> answer = new ArrayList<>();

		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < code.length; i++) {
			int key = 0;
			if (code[i].startsWith(".")) {
				key++;
				while (code[i].charAt(key) == '.') {
					key++;
				}
			}

			if (hm.containsKey(key)) {
				code[i] = key + " " + code[i].substring(key);
				hm.put(key, hm.getOrDefault(key, 0) + 1);
//				System.out.println(code[i]);
			} else {
				code[i] = key + " " + code[i].substring(key);
				hm.put(key, 1);
//				System.out.println(code[i]);
			}
		}

		Stack<String> a = new Stack<>();
		Stack<String> b = new Stack<>();
		for (String c : code) {
			String[] split = c.split(" ");
			int key = Integer.parseInt(split[0]);

			if (split[1].startsWith("a")) {
				a.add(c);
			} else if (split[1].startsWith("b")) {
				b.add(c);
			} else {// print
				if (split[2].equals("a")) {
					if (a.isEmpty()) {
						answer.add("error");
					} else {
						String[] tmp = a.peek().split(" ");
						answer.add(tmp[1]);
					}
				} else {
					if (b.isEmpty()) {
						answer.add("error");
					} else {
						String[] tmp = b.peek().split(" ");
						answer.add(tmp[1]);
					}
				}
			}
			
			hm.replace(key, hm.get(key) - 1);
			if (key != 0 && hm.get(key) == 0) {
				if (!a.isEmpty()) {
					if (a.peek().startsWith(split[0])) {
						a.pop();
					}
				}

				if (!b.isEmpty()) {
					if (b.peek().startsWith(split[0])) {
						b.pop();
					}
				}

			}
		}

		return answer.toArray(new String[answer.size()]);
	}
}
