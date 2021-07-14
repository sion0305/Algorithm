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



class Result {

    /*
     * Complete the 'decode' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY codes
     *  2. STRING encoded
     */

    public static String decode(List<String> codes, String encoded) {
    // Write your code here
        StringBuilder result = new StringBuilder();
        HashMap<String, String> hm = new HashMap<>();
        
        for(String c : codes){
            String[] cut = c.split("\t");
            // System.out.println(cut[0]  + " : " + cut[1]);
            if(cut[0].equals("[newline]")){
                cut[0] = "\n";
            }
            hm.put(cut[1], cut[0]);
        }
        
        int size = encoded.length();
        StringBuilder tmp = new StringBuilder();
        for(int i = 0; i < size; i++){
            tmp.append(encoded.charAt(i));
            if(hm.containsKey(tmp.toString())){
                result.append(hm.get(tmp.toString()));
                tmp = new StringBuilder();
            }
            
            // System.out.println(tmp + " : " + hm.get(tmp.toString()));
            
        }
        
        return result.toString();
    }

}

public class Solution_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int codesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> codes = IntStream.range(0, codesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        String encoded = bufferedReader.readLine();

        String result = Result.decode(codes, encoded);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
