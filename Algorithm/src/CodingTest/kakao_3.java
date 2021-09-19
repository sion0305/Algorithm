package CodingTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class kakao_3 {

	public static void main(String[] args) throws ParseException {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
	
		int[] answer = solution(fees, records);
	
        
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static int[] solution(int[] fees, String[] records) throws ParseException {
        HashMap<String, Long> accumTime = new HashMap<>();
        HashMap<String, Long> inTime = new HashMap<>();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        
        List<String> carNum = new ArrayList<>();
        
        for(String r : records) {
        	String[] split = r.split(" ");
        	String car = split[1];
        	
        	Date dateTime = dateFormat.parse(split[0]);
        	long time = dateTime.getTime();
        		
        	if(split[2].equals("IN")) {
        		if(!carNum.contains(car)) carNum.add(car);
        		inTime.put(car, time);
        	}else {
        		long calcTime = (time - inTime.remove(car)) / 60000;
        		
        		accumTime.put(car, accumTime.getOrDefault(car, 0l) + calcTime);
        	}
        }
        
        if(!inTime.isEmpty()) {
        	Set<String> restCar = inTime.keySet();
        	Date dateTime = dateFormat.parse("23:59");
        	long time = dateTime.getTime();
        	
        	for(String rest  : restCar) {
        		long calcTime = (time - inTime.remove(rest)) / 60000;
        		
        		accumTime.put(rest, accumTime.getOrDefault(rest, 0l) + calcTime);
        	}
        }
        
        Collections.sort(carNum);
        
        int[] answer = new int[carNum.size()];
        
        for(int i = 0; i < carNum.size(); i++) {
        	long time = accumTime.get(carNum.get(i));
        	
        	if(time <= fees[0]) {
        		answer[i] = fees[1];
        		continue;
        	}
        	
        	int total = fees[1];
        	long calc = time - fees[0];
        	total += (int) Math.ceil((float)calc / fees[2]) * fees[3];
        	answer[i] = total;
        }
        
        return answer;
    }
}
