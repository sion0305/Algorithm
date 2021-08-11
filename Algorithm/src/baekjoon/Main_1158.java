package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1158 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        String input = br.readLine();
        
        String[] arr = input.split(" ");
        
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);
        
		Queue<Integer> queue = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder("<");
        // 스트링 빌더 생성
		
		for(int i = 1; i <= n; i++) {
			queue.offer(i);
		}
        
        while(queue.size() != 1) {
			for(int j = 1; j <= k; j++) {
				if(j != k) {
					queue.offer(queue.poll());
				}else {
					sb.append(queue.poll());
					sb.append(", ");
				}
			}
		}
        sb.append(queue.poll());
        
		sb.append(">");
		
		bw.write(sb.toString() + "\n");
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}
