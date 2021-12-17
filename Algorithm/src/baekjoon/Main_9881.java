package baekjoon;

import java.io.*;
import java.util.*;

public class Main_9881{
    
    public static void main(String[] args){
        Main main = new Main();
        main.run();
    }
    
}

class Hill implements Comparable<Hill>{
    public int height, mass;
    
    public Hill(int height){
        this.height = height;
        this.mass = 0;
    }
    
    @Override
    public int compareTo(Hill hill){
        if(this.height > hill.height) return 1;
        if(this.height < hill.height) return -1;
        return 0;
    }
    
}

class Main{
	static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static private int N;
	static private ArrayList<Hill> hill = new ArrayList<Hill>();
    
    public void run(){
        input();
        int ans = 987654321;
        for(int i = hill.get(0).height; i < hill.get(N-1).height; i++){
            if(i+17 > hill.get(N-1).height) break;
            ans = Math.min(ans,calc(i,i+17));
        }
        if(ans == 987654321) ans = 0;
        System.out.println(ans);
    }
    
    private static void input(){
        try{
            N = Integer.parseInt(br.readLine());
            for(int i = 1; i <= N; i++){
                int num = Integer.parseInt(br.readLine());
                hill.add(new Hill(num));
            }
            Collections.sort(hill);
        } catch (IOException ioe){}
    }
    
    private static int calc(int min, int max){
        int ret = 0;
        for(int i = 0; i < N; i++){
            hill.get(i).mass = 0; // 초기화
            if(hill.get(i).height < min) hill.get(i).mass = min - hill.get(i).height;
            if(hill.get(i).height > max) hill.get(i).mass = hill.get(i).height - max;
            ret += Math.pow(hill.get(i).mass,2);
        }
        return ret;
    }
}