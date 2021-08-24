package Programmers;

import java.util.*;

public class 순위_검색_0 {

	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		int[] answer = solution(info, query);
		
		for(Integer a : answer) {
			System.out.println(a);
		}
	}

	public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        int[] score = new int[query.length];
        
        for(int i = 0; i < query.length; i++) {
        	String q = query[i];
        	
        	q = q.replaceAll(" and ", " ");
//        	q = q.replaceAll("- ", "");
        	
//        	System.out.println(q);
        	
        	String[] split = q.split(" ");
        	score[i] = Integer.parseInt(split[split.length-1]);
        	
        	q = q.replace(" " + split[split.length-1], "");
        	
        	query[i] = q;
        	
//        	System.out.println(score[i]);
        }
        
        for(int i = 0; i < query.length; i++) {
        	String q = query[i];
        	System.out.println("q : " + q);
        	
        	String[] qSpt = q.split(" ");
        	
        	for(int j = 0; j < info.length; j++) {
        		String s = info[j];
        		System.out.println("s : "+ s);
        		
        		if(s.contains(q)) {
        			System.out.println("yes");
        			String[] split = s.split(" ");
        			int num = Integer.parseInt(split[split.length-1]);
        			if(num >= score[i]) {
        				System.out.println("YYYES");
        				answer[i]++;
        			}
        		}
        	}
        }
        
        
        return answer;
    }
	
}
