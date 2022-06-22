package baekjoon.clear;

import java.util.*;

public class Main_2805 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      
      int m = sc.nextInt();
      
      int[] tree = new int[n];
      
      long start = 0;
      long end = 0;
      
      for(int i = 0; i < n; i++) {
         tree[i] = sc.nextInt();
         end = Math.max(end, tree[i]);
      }

      Arrays.sort(tree);


      while(start <= end) {
         long mid = (start + end) / 2;
         long sum = 0;
         
         for(int t : tree) {
            if(t > mid) {
               sum += t-mid;
            }
         }
         
         if(sum >= m) {
            start = mid+1;
         }else {
            end = mid-1;
         }
      }
      
      System.out.println(end);
   }

}