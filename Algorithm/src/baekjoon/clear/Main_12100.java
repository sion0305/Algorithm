package baekjoon.clear;

import java.util.Scanner;
import java.util.Stack;

public class Main_12100 {

	private static int n, max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int[][] board = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		solution(board, 0);
		System.out.println(max);
	}
	
	public static void solution(int[][] board, int count) {
		if(count == 5) {
			findMax(board);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			solution(move(board,i), count+1);
		}
	}
	
	public static int[][] move(int[][] board, int dir) {
		int[][] result = new int[n][n];
		Stack<Integer> stack = new Stack<>();
		boolean flag = true;
		
		switch(dir) {
		case 0:
			for(int j = 0; j < n; j++) {
				for(int i = 0; i < n; i++) {
					int temp = board[i][j];
					if(temp != 0) {
						if(stack.isEmpty()) {
							stack.add(temp);
						}else {
							if(stack.peek() == temp && flag) {
								stack.add(stack.pop() * 2);
								flag = false;
								continue;
							}else {
								stack.add(temp);
							}
						}
						flag = true;
					}
				}
				while(!stack.isEmpty()) {
					int i = stack.size() - 1;
					result[i][j] = stack.pop();
				}
				stack.clear();
			}
			break;
		case 1:
			for(int j = 0; j < n; j++) {
				for(int i = n-1; i >= 0; i--) {
					int temp = board[i][j];
					if(temp != 0) {
						if(stack.isEmpty()) {
							stack.add(temp);
						}else {
							if(stack.peek() == temp & flag) {
								stack.add(stack.pop() * 2);
								flag = false;
								continue;
							}else {
								stack.add(temp);
							}
						}
						flag = true;
					}
				}
				while(!stack.isEmpty()) {
					int i = stack.size() - 1;
					result[i][j] = stack.pop();
				}
				stack.clear();
			}
			break;
		case 2:
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int temp = board[i][j];
					if(temp != 0) {
						if(stack.isEmpty()) {
							stack.add(temp);
						}else {
							if(stack.peek() == temp && flag) {
								stack.add(stack.pop() * 2);
								flag = false;
								continue;
							}else {
								stack.add(temp);
							}
						}
						flag = true;
					}
				}
				while(!stack.isEmpty()) {
					int j = stack.size() - 1;
					result[i][j] = stack.pop();
				}
				stack.clear();
			}
			break;
		case 3:
			for(int i = 0; i < n; i++) {
				for(int j = n-1; j >= 0; j--) {
					int temp = board[i][j];
					if(temp != 0) {
						if(stack.isEmpty()) {
							stack.add(temp);
						}else {
							if(stack.peek() == temp & flag) {
								stack.add(stack.pop() * 2);
								flag = false;
								continue;
							}else {
								stack.add(temp);
							}
						}
						flag = true;
					}
				}
				while(!stack.isEmpty()) {
					int j = stack.size() - 1;
					result[i][j] = stack.pop();
				}
				stack.clear();
			}
			break;
		}
		return result;
	}

	public static void findMax(int[][] board) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(max < board[i][j]) {
					max = board[i][j];
				}
			}
		}
	}
}