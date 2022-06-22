package baekjoon.clear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_5827 {
	static int N;
	static int M;
	static int ans;
	static char[][] map;
	static int[][][] visit;
	static int[][] pos = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

	static class Captain implements Comparable<Captain> {
		int y;
		int x;
		int cnt;
		int dir;

		public Captain(int y, int x, int cnt, int dir) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.dir = dir;
		}

		public int compareTo(Captain o) {
			return this.cnt - o.cnt;
		}

		@Override
		public String toString() {
			return "Captain [y=" + y + ", x=" + x + ", cnt=" + cnt + ", dir=" + dir + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = -1;

		map = new char[N][M];
		visit = new int[N][M][2];
		int sy = 0;
		int sx = 0;
		int ey = 0;
		int ex = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'C') {
					sy = i;
					sx = j;
				}
				if (map[i][j] == 'D') {
					ey = i;
					ex = j;
				}
				for (int k = 0; k < 2; k++) {
					visit[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		PriorityQueue<Captain> pq = new PriorityQueue<>();
		pq.offer(new Captain(sy, sx, 0, 0));
		visit[sy][sx][0] = 0;
		top: while (!pq.isEmpty()) {
			Captain c = pq.poll();
//			System.out.println(c);
			if (c.y == ey && c.x == ex) {
				ans = c.cnt;
				break;
			}
			// 중력 적용 하기
			// down
			int ny = c.y;
			if (c.dir == 0) {
				while (true) {
					if (ny >= N - 1)
						continue top;
					if (map[ny + 1][c.x] == '#')
						break;
                    // 3번 떨어지는 중에 미리 체크
					if (map[ny + 1][c.x] == 'D') {
						ans = c.cnt;
						break top;
					}
					ny++;
				}
			}
			// up
			else {
				while (true) {
					if (ny <= 0)
						continue top;
					if (map[ny - 1][c.x] == '#')
						break;
					if (map[ny - 1][c.x] == 'D') {
						ans = c.cnt;
						break top;
					}
					ny--;
				}
			}
			if (visit[ny][c.x][c.dir] > c.cnt + 1) {
				pq.offer(new Captain(ny, c.x, c.cnt, c.dir));
				visit[ny][c.x][c.dir] = c.cnt;
			}
			// 중력 전환
			if (visit[ny][c.x][(c.dir + 1) % 2] > c.cnt + 1) {
				pq.offer(new Captain(ny, c.x, c.cnt + 1, (c.dir + 1) % 2));
				visit[ny][c.x][(c.dir + 1) % 2] = c.cnt + 1;
			}
			// left
			int nx = c.x - 1;
            // 2번 map[ny][nx] -> (map[ny][nx] =='.' || map[ny][nx] =='D')
			if (nx > -1 && (map[ny][nx] == '.' || map[ny][nx] == 'D') && visit[ny][nx][c.dir] > c.cnt + 1) {
				pq.offer(new Captain(ny, nx, c.cnt, c.dir));
				visit[ny][nx][c.dir] = c.cnt;
			}
			// right
			nx = c.x + 1;
            // 1번 N -> M
			if (nx < M && (map[ny][nx] == '.' || map[ny][nx] == 'D') && visit[ny][nx][c.dir] > c.cnt + 1) {
				pq.offer(new Captain(ny, nx, c.cnt, c.dir));
				visit[ny][nx][c.dir] = c.cnt;
			}
		}
		System.out.println(ans);
	}
}
