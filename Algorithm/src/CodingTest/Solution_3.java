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


class Result3 {

    /*
     * Complete the 'reachTheEnd' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid
     *  2. INTEGER maxTime
     */

    public static String reachTheEnd(List<String> grid, int maxTime) {
    // Write your code here
        int row = grid.size();
        int col = grid.get(0).length();
        
        if(row -1 == 0 && col -1 == 0) return "Yes";

        int[][] board = new int[row][col];
        boolean[][] visit = new boolean[row][col];
        int[][] dirs = {{-1,0}, {1, 0}, {0,-1}, {0,1}};
        
        for(int i = 0; i < row; i++){
            String[] tmp = grid.get(i).split("");
            for(int j = 0; j < col; j++){
                if(tmp[j].equals(".")){
                    board[i][j] = 0;
                }else{
                    board[i][j] = -1;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0});
        
        while(!q.isEmpty()){
            int[] p = q.poll();
            visit[p[0]][p[1]] = true;
            
            for(int[] d : dirs){
                int x = p[0] + d[0];
                int y = p[1] + d[1];
                
                if(x >= 0 && x < row && y >= 0 && y < col && board[x][y] != -1 && !visit[x][y]){
                    board[x][y] = board[p[0]][p[1]] + 1;
                    q.offer(new int[] {x,y});
                    visit[x][y] = true;
                }
            }
        }
        System.out.println(board[row-1][col-1]);
        
        if(board[row-1][col-1] == 0 || board[row-1][col-1] > maxTime){
            return "No";
        }else{
            return "Yes";
        }
                
    }

}
public class Solution_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gridCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, gridCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int maxTime = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result3.reachTheEnd(grid, maxTime);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
