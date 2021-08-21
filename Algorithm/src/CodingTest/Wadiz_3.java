package CodingTest;

import java.util.*;
import java.util.stream.Collectors;

public class Wadiz_3 {//½ÇÆÐ

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 0, 10, 0, 10, 0};
//		5, 4, 5, 4, 5, 5
//		1, 3, 5, 7, 6, 8, 9, 5, 1
//		1, 2, 4, 8, 4, 2, 1
		
		System.out.println(solution(arr));
	}

	public static int solution(int[] arr) {
		int answer = 0;
		int[] A = new int[arr.length];
		
		for(int a : A) {
			System.out.print( a + " ");
		}
		
		int i = 0, j = i;
		
		ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
		list = (ArrayList<Integer>) list.parallelStream().distinct().collect(Collectors.toList());
		Collections.sort(list);
		
		if(list.contains(0)) {
			list.remove(0);
		}
		
		System.out.println(list);
		
		int idx = 0;
		int value = list.get(idx);
		
		boolean[] change = new boolean[arr.length];
		
		for(int k = 0; k < change.length; k++) {
			if(A[k] == arr[k]) {
				change[k] = false;
				
			}
			System.out.print(change[k] + " ");
		}
		
		boolean finish = false;
		
		while(!finish) {
			value = list.get(idx);
			
			while(A[j] == arr[j]) {
				j++;
			}
			
			System.out.println(i + " , " + j);			
			
			for(int k = i; k <= j; k++) {
				A[k] += value - A[k];
				if(A[k] == arr[k]) {
					change[k] = false;
				}
				System.out.println(A[k] + " " + change[k]);
			}
			
			answer++;
			
			for(int k = 0; i < change.length; i++) {
				if(change[k]) {
					i = k;
					break;
				}
				finish = true;
			}
			j = i;
			System.out.println(i + " , " + j);
			
		}
		
		return answer;
	}
}
