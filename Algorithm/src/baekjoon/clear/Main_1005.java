package baekjoon.clear;

import java.util.*;

public class Main_1005 {

	static int n, w;
    static ArrayList<Integer>[] list;
    static int[] building; 
    static int[] indegree;
    static int[] buildCost; 
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        int t = scan.nextInt();
        for(int i = 0; i < t; i++) {
            n = scan.nextInt();
            int k = scan.nextInt();
            
            building = new int[n + 1];
            list = new ArrayList[n + 1];
            for(int j = 1; j <= n; j++) {
                building[j] = scan.nextInt();
                list[j] = new ArrayList<>();
            }
            
            indegree = new int[n + 1];
            for(int j = 0; j < k; j++) {
                int s = scan.nextInt();
                int e = scan.nextInt();
                list[s].add(e); 
                indegree[e]++;
            }
            w = scan.nextInt(); //�Ǽ��ؾ� �� �ǹ��� ��ȣ
            
            buildCost = new int[n + 1]; 
            
            Queue<Integer> q = new LinkedList<>();
            for(int j = 1; j < indegree.length; j++) {
                if(indegree[j] == 0) {
                    buildCost[j] = building[j];
                    q.offer(j);
                }
            }
            
            while(!q.isEmpty()) {
                int current = q.poll();
                
                for(int j = 0; j < list[current].size(); j++) {
                    int next = list[current].get(j);
                    buildCost[next] = Math.max(buildCost[current] + building[next], buildCost[next]);
                    indegree[next]--;
                    if(indegree[next] == 0) q.offer(next);
                }
            }
            
            System.out.println(buildCost[w]);
        }
    }
    
}
