package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1920 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      
      int[] arr = new int[n];
      
      for(int i = 0; i < n; i++) {
         arr[i] = sc.nextInt();
      }
      
      Arrays.sort(arr);
      
      int m = sc.nextInt();
      
      for(int i = 0; i < m; i++) {
         int tmp = sc.nextInt();
         System.out.println(binarySearch(arr, tmp, 0, n-1));
      }

   }
   
   public static int binarySearch(int[] arr, int target, int start, int end) {
      while(start <= end) {
         int mid = (start + end) / 2;
         
         if(arr[mid] == target) return 1;
         
         else if(arr[mid] > target) end = mid - 1;
         
         else start = mid + 1;
      }
      
      return 0;
   }

}