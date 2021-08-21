package CodingTest;

import java.util.*;

public class Wadiz_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution(int[][] passwords, String s) {
        int answer = 0;
        
        String[] split = s.split("#");
        
        HashMap<Integer, Integer> pw = new HashMap<>();
        for(int i = 0; i < passwords.length; i++) {
        	pw.put(passwords[i][0], passwords[i][1]);
        }
        
        boolean isRight = false;
        int key = 0;
        for(int i = 0; i < split.length; i++) {
        	int num = Integer.parseInt(split[i]);
        	if(!isRight) {
        		if(pw.containsKey(num)) {
        			isRight = true;
        			key = num;
        		}
        	}else {
        		if(pw.get(key) == num) {
        			answer++;
        		}
        		isRight = false;
        	}
        }
        return answer;
    }

}
