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



class Result2 {

    /*
     * Complete the 'getMinDeletions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int getMinDeletions(String s) {
    // Write your code here
        String[] cut = s.split("");
        int count = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String c : cut){
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }
        
        for(String c : cut){
            int get = hm.get(c);
            if(get > 1){
                hm.replace(c, get-1);
                count++;
            }
        }
        
        return count;
    }

}

public class Solution_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result2.getMinDeletions(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
