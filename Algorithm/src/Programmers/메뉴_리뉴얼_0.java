package Programmers;

import java.util.*;

public class 메뉴_리뉴얼_0 {

	//참고하고 내스타일로 수정
	public static void main(String[] args) {
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		
		String[] answer = solution(orders, course);

		for(String s : answer) {
			System.out.println(s);
		}
	}
	static Map<Integer, Map<String, Integer>> map = new HashMap<>();
	
	public static String[] solution(String[] orders, int[] course) {
		for (int c : course) map.put(c, new HashMap<>());
		
        ArrayList<String> result = new ArrayList<>();
        
        for(int i = 0; i < orders.length; i++) {
        	char[] c = orders[i].toCharArray();
        	
        	Arrays.sort(c);
        	
        	
        	perm(c, "", 0);
        }
        
        for(int n : course) {
        	Map<String, Integer> tmp = map.get(n);
        	
        	if(tmp == null) {
        		System.out.println("tmp is null");
        		continue;
        	}
        	
        	System.out.println(n);
        	Set<String> key = tmp.keySet();
        	
        	int max = 0;
        	for(String k : key) {
        		int count = tmp.get(k);
        		if(count > 1 && count > max)
        			max = count;
        	}
        	
        	for(String k : key) {
        		int count = tmp.get(k);
        		if(count == max) {
        			result.add(k);
        		}
        	}
        }
        
        Collections.sort(result);
        
        return result.toArray(new String[result.size()]);
    }
	
	static void perm(char[] order, String course, int idx) {
		if(map.containsKey(course.length())) {
			int len = course.length();
			map.get(len).put(course, map.get(len).getOrDefault(course, 0)+1);
		}
		
		for(int i = idx; i < order.length; i++) {
			perm(order, course + order[i], i + 1);
		}
	}
}
