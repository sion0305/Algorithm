package baekjoon;

import java.util.Scanner;

public class Main_10830 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		long b = sc.nextLong();
		
		int[][] matrix = new int[N][N];

		for(int i = 0; i < N; i++) {
			for(int  j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		int[][] result = solution(matrix, b);
		
		for(int i = 0; i < N; i++) {
			for(int j =0; j < N; j++) {
				System.out.print(result[i][j] % 1000 + " ");
			}
			System.out.println();
		}
		
	}
	
	static int[][] square(int[][] a, int[][] A) {
        int[][] temp = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int sum = 0;
                for(int k=0; k<N; k++) {
                    sum += a[i][k]*A[k][j];
                }
                temp[i][j] = sum%1000;
            }
        }

        return temp;
    }

    static int[][] solution(int[][] a, long b) {
        if(b==1)
            return a;
        else if(b%2==0) {
            int[][] temp = solution(a, b/2);
            return square(temp, temp);
        }
        else {
            return square(solution(a, b-1), a);
        }
    }
}
