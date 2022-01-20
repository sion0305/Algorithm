package CodingTest;

import java.util.*;
import java.util.stream.Collectors;
class Solution {
    static int pSize;
    static int cSize;
    static int n;
    public int solution() {
        int answer = 0;
        
        int[][] needs =  {{ 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
        int r = 2;
        
        pSize = needs.length;//완제품개수
        cSize = needs[0].length;//부품개수
        n = r;
        
        dfs(needs, 0);
        
        return max;
    }
    
    static int max = 0;
    static boolean[] visited = new boolean[cSize];
    static int[] temp = new int[n];
    
    public static void dfs(int[][] needs, int depth){
        if(depth == n){
            checkCount(needs);
            return;
        }
        
        for(int i = 0 ; i < cSize; i++){
        	if(visited[i]) continue;
            visited[i] = true;
            temp[depth] = i;
            dfs(needs, depth+1);
            visited[i] = false;
        }
    }
    
    public static void checkCount(int[][] needs){
        List<Integer> list = (ArrayList<Integer>) Arrays.stream(temp).boxed().collect(Collectors.toList());
        int count = 0;
        for(int i = 0; i < pSize; i++){
            boolean can = true;
            for(int j = 0; j < cSize; j++){
                if(needs[i][j] == 1){
                    if(!list.contains(j)){
                        can = false;
                    }
                }
            }
            if(can) count++;
        }
        
        max = Math.max(max, count);
    }
}