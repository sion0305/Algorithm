package baekjoon.clear;

import java.util.*;

class Hole implements Comparable<Hole>{
    public int y, x, idx;
    private Hole hole;
    
    public Hole(int y, int x){
        set(y,x);
    }
    
    private void set(int y, int x){
        this.y = y;
        this.x = x;
    }
    
    public void connect(Hole warp){
        this.hole = warp;
        warp.hole = this;
    }
    
    public Hole getHole(){
        return this.hole;
    }
    
    @Override
    public int compareTo(Hole hole){
        if(this.y > hole.y) return 1;
        if(this.y < hole.y) return -1;
        if(this.y == hole.y){
            if(this.x > hole.x) return 1;
            if(this.x < hole.x) return -1;
        }
        return 0;
    }
    
}

public class Main_9874 {
	static int N;
	static List<Hole> wormHoles = new ArrayList<>();
	static boolean[] connected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		connected = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			wormHoles.add(new Hole(b,a));
		}
		
		Collections.sort(wormHoles);
        for(int i = 0; i < N; i++) wormHoles.get(i).idx = i;
        
       System.out.println(connectWormHole(0,0));
	}
	
	private static int connectWormHole(int idx, int connect){
        int ret = 0;
        if(connect == N){
            for(int i = 0; i < N; i++){
                if(loopCheck(wormHoles.get(i))) return 1;
            }
            return 0;
        }
        for(int A = idx; A < N; A++){
            if(connected[A]) continue;
            connected[A] = true;
            for(int B = A+1; B < N; B++){
                if(connected[B]) continue;
                connected[B] = true;
                wormHoles.get(A).connect(wormHoles.get(B));
                ret += connectWormHole(A+1, connect+2);
                connected[B] = false;
            }
            connected[A] = false;
        }
        return ret;
    }
	
	private static boolean loopCheck(Hole hole){ // true : loop, false : noloop
        boolean[] visited = new boolean[N+5];
        while(true){
            if(visited[hole.idx]) return true; // 이미 들어갔던 웜홀인지 체크 맞다면 return true
            visited[hole.idx] = true; // 아니라면 true
            hole = hole.getHole(); // 연결된 웜홀로 나오기
            hole = nextHole(hole); // +x 방향으로 이동했을때 다음 구멍 찾기
            if(hole == null){ // 다음 구멍이 없다면, 
                return false;
            }
        }
    }
    
    private static Hole nextHole(Hole hole){
        for(int i = 0; i < N; i++){
            Hole wormHole = wormHoles.get(i);
            if(wormHole.y == hole.y && wormHole.x > hole.x) return wormHole;
        }
        return null;
    }

}
