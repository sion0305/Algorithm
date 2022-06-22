package baekjoon.clear;

import java.util.*;

public class Main_2512 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); 
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        long answer = 0;
        Arrays.sort(arr);
        long M = sc.nextLong(); 
        long left = 0;
        long right = arr[N-1];
        
        while (left <= right) {
            long mid = (left + right) / 2; 
            long sum = 0;
            
            for (int money : arr) {
                if (money >= mid) sum += mid; 
                else sum += money; 
            }
            if (sum > M) { 
                right = mid - 1;
            } else { 
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
    }

}