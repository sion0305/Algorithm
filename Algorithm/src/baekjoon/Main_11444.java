package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class Main_11444 {
	static HashMap<Long, Long> d = new HashMap<Long, Long>();
	static long p = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		
		long result = fibo(n);
		
		System.out.println(result);
		System.out.println(pisano_period(7));
	}
	
	static long fibo(long n) {
		if(n <= 0)
			return 0;
		else if(n == 1 || n == 2) 
			return 1;
		else if(d.containsKey(n))
			return d.get(n);
		
		else {
			if(n % 2 == 1) {
				long i = (n+1) / 2;
				long t1 = fibo(i);
				long t2 = fibo(i-1);
				d.put(n, (t1 * t1 + t2 * t2) % p);
				return d.get(n);
			}else {
				long i = n / 2;
				long t1 = fibo(i-1);
				long t2 = fibo(i);
				d.put(n, ((2*t1 + t2) * t2)%p);
				return d.get(n);
			}
		}
	}
	
	public static int pisano_period(int m) {
        int period = 0;
        int number1 = 1, number2 = 1;
        do {
            int temp = number1;
            number1 = number2;
            number2 = (temp + number2) % m;
            period++;
        } while (!(number1 == 1 && number2 == 1));
        return period;
    }
}
