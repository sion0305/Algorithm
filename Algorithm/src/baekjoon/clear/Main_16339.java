package baekjoon.clear;

import java.util.*;

public class Main_16339 {

	static int[][] max, min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        char[] s = sc.next().toCharArray();
        
        max = new int[N][N];
        min = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
        
        for(int i = 0; i < N; i++) {
            if(Character.isDigit(s[i])) {
//            	if(s[i] > '0' && s[i] < '9') {
                max[i][i] = s[i] - '0';
                min[i][i] = s[i] - '0';
            }
        }
        
        for(int j = 2; j < N; j+=2) {
            for(int i = 0; i < N - j; i+=2) {
                for(int k = 2; k <= j; k+=2) {
                    int[] num = new int[4];
                    int op = i + k - 1;
                    
                    num[0] = calc(max[i][i + k - 2], max[i + k][i + j], s[op]);
                    num[1] = calc(max[i][i + k - 2], min[i + k][i + j], s[op]);
                    num[2] = calc(min[i][i + k - 2], max[i + k][i + j], s[op]);
                    num[3] = calc(min[i][i + k - 2], min[i + k][i + j], s[op]);
                    
                    Arrays.sort(num);
                    
                    max[i][i + j] = Math.max(max[i][i + j], num[3]);
                    min[i][i + j] = Math.min(min[i][i + j], num[0]);
                }
            }
        }
        
        System.out.println(max[0][N - 1]);
    }

    public static int calc(int a, int b, char op) {
        if(op == '+') return a + b;
        else if(op == '-') return a - b;
        else return a * b;
    }

}
