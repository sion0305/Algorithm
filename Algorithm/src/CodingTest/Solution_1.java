package CodingTest;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution_1 {



    // Complete the maxTickets function below.
    static int maxTickets(List<Integer> tickets) {
        Collections.sort(tickets);
        System.out.println(tickets.size());
        
        ArrayList<Integer> counts = new ArrayList<>();
        
        System.out.println(tickets.get(tickets.size()-1));
        int count = 1;
        for(int i = tickets.size()-1; i > 0; i--){
            if(tickets.get(i)-1 == tickets.get(i-1) || tickets.get(i) == tickets.get(i-1)){
                count++;
                System.out.println("연속" + i + " : " + tickets.get(i) + " && " + tickets.get(i-1));
            }else{
            	System.out.println("연속이 아니야" + count);
                counts.add(count);
                count = 1;
            }
        }
        counts.add(count);
        
        Collections.sort(counts, Collections.reverseOrder());

        return counts.get(0);
    }

    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       
       int size = sc.nextInt();
       List<Integer> t = new ArrayList<>();
       
       for(int i = 0; i < size; i++) {
    	   int n = sc.nextInt();
    	   t.add(n);
       }
       
       System.out.println(maxTickets(t));
    }
}
