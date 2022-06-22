package baekjoon.clear;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1644 {
	static List<Integer> prime = new ArrayList<>();
	public static boolean[] primeNumcheck;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		primeNumcheck = new boolean[n+1];
		
//		for(int i = 2; i <= n; i++) {
//			if(isPrime(i)) {
//				prime.add(i);
//			}
//		}
		
		primeNumcheck[0]=primeNumcheck[1]=true;
        for(int i =2; i*i<=n; i++){
            if(!primeNumcheck[i]){
                for (int j = i*i; j <=n ; j += i) {
                    primeNumcheck[j]=true;
                }
            }
        }
        for (int i = 1; i <=n ; i++) {
            if(!primeNumcheck[i]){
                prime.add(i);
            }
        }
        
        System.out.println(countSum(n));
        
	}

	static boolean isPrime(int n) {
		for(int j = 2; j < n; j++) {
			if(n % j == 0) {
				return false;
			}
		}
		return true;
	}
	
	static int countSum(int n) {
		int sum = 0, count = 0;
		int start = 0, end = 0;
		
		while (true){
            if(sum >= n){
                sum -= prime.get(start++);
            }else if(end == prime.size()){
                break;
            }else {
                sum += prime.get(end++);
            }
            if(n==sum){
                count++;
            }
        }
		
		return count;
	}
}
