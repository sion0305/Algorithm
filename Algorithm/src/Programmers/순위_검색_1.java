package Programmers;

import java.util.*;

public class 순위_검색_1 {

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

		int[] answer = solution(info, query);

		for (Integer a : answer) {
			System.out.println(a);
		}
	}

	static HashMap<String, List<Integer>> map = new HashMap<>();

	public static int[] solution(String[] info, String[] query) {

		int[] answer = new int[query.length];
		int[] score = new int[query.length];
		String[] condition = new String[query.length];

		for (int i = 0; i < query.length; i++) {
			String q = query[i];
			q = q.replaceAll(" and ", " ");

			String[] split = q.split(" ");

			score[i] = Integer.parseInt(split[4]);

			condition[i] = split[0] + split[1] + split[2] + split[3];

//			System.out.println("조건 : " + condition[i]);

			map.putIfAbsent(condition[i], new ArrayList<>());
		}

		for (int i = 0; i < info.length; i++) {
			String[] split = info[i].split(" ");

			comb("", split, 0, 0);
		}

		Iterator<String> key = map.keySet().iterator();
		while (key.hasNext()) {
			List<Integer> tmp = map.get(key.next());
			Collections.sort(tmp);
		}

		for (int i = 0; i < query.length; i++) {
			List<Integer> num = map.get(condition[i]);

			if (num.size() > 0) {
				int start = 0;
				int end = num.size() - 1;
				while (start <= end) {
					int mid = (start + end) / 2;

					if (num.get(mid) < score[i])
						start = mid + 1;
					else
						end = mid - 1;
				}
				answer[i] = num.size() - start;
			}
		}

		return answer;
	}

	public static void comb(String sb, String[] tmp, int idx, int count) {
		if (count == 4) {
			if (map.containsKey(sb)) {
//				System.out.println("찾았다 : " + sb);

				List<Integer> t = map.get(sb);

				t.add(Integer.parseInt(tmp[4]));
				map.replace(sb, t);
				return;
			}else {
				return;
			}
		}

		comb(sb + tmp[idx], tmp, idx + 1, count + 1);
		comb(sb + '-', tmp, idx + 1, count + 1);
	}

}
