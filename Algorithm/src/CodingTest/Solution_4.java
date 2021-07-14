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


class Main {

    /*
     * Complete the 'maxEvents' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arrival
     *  2. INTEGER_ARRAY duration
     */

    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
    // Write your code here
        int size = arrival.size();
        int[][] time = new int[size][2];
        
        for(int i = 0; i < size; i++){
            time[i][0] = arrival.get(i);
            time[i][1] = arrival.get(i) + duration.get(i);
        }
        
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        
        int count = 0;
        int prev = 0;
        
        for(int i = 0; i < size; i++){
            if(prev <= time[i][0]){
                prev = time[i][1];
                count++;
            }
        }
        
        return count;
    }

}
public class Solution_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrivalCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arrival = IntStream.range(0, arrivalCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int durationCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> duration = IntStream.range(0, durationCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Main.maxEvents(arrival, duration);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
