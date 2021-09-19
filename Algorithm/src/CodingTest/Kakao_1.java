package CodingTest;

import java.util.*;

public class Kakao_1 {

	public static void main(String[] args) {
		String[] id_list = {"con", "ryan"};
		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k = 3;
		
		int[] result = solution(id_list, report, 3);
		
		for(int i : result) {
			System.out.println(i);
		}
	}

	    public static int[] solution(String[] id_list, String[] report, int k) {
	        int[] answer = new int[id_list.length];
	        
	        HashMap<String, List<String>> reported = new HashMap<>();
	        HashMap<String, Integer> warning = new HashMap<>();
	        
	        for(String r : report) {
	        	String[] split = r.split(" ");
	        	
	        	String warning_id = split[1];
	        	
	        	List<String> reportList;
	        	if(reported.containsKey(warning_id)) {
	        		reportList = reported.get(warning_id);
	        		if(reportList.contains(split[0])) {
	        			continue;
	        		}
	        		reportList.add(split[0]);
	        	}else {
	        		reportList = new ArrayList<>();
	        		reportList.add(split[0]);
	        	}
	        	
	        	reported.put(warning_id, reportList);
	        	warning.put(warning_id, warning.getOrDefault(warning_id, 0) + 1);
	        }
	        
	        HashMap<String, Integer> email = new HashMap<>();
	        
	        for(String id : id_list) {
	        	if(!warning.containsKey(id)) continue;
	        	
	        	if(warning.get(id) >= k) {
	        		List<String> report_id = reported.get(id);
	        		
	        		for(String r : report_id) {
	        			email.put(r, email.getOrDefault(r, 0) + 1);
	        		}
	        	}
	        }
	        
	        for(int i = 0; i < id_list.length; i++) {
	        	if(!email.containsKey(id_list[i])) continue;
	        	
	        	answer[i] = email.get(id_list[i]);
	        }
	        
	        return answer;
	    }
	}

