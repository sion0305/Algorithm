package baekjoon.clear;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_17780 {
    static final int WHITE = 0, RED = 1, BLUE = 2;
    static final int[] change = { 1, 0, 3, 2 };
    // ��, ��, ��, ��
    static final int[] dr = { 0, 0, -1, 1 };
    static final int[] dc = { 1, -1, 0, 0 };

    static int N, K;
    static int[][] map;
    static LinkedList<Integer>[][] state;
    static Horse[] horses;

    static class Horse {
        int r, c, dir;

        Horse(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // ü������ ũ�� N
        K = sc.nextInt(); // ���� ���� K

        map = new int[N][N]; // ü���� ���� ����
        state = new LinkedList[N][N]; // ü���ǿ� ���� ���� ����

        // ü������ ����
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                state[i][j] = new LinkedList<>();
            }
        }

        // ���� ����
        horses = new Horse[K + 1]; // 1 ~ K�� ��
        for (int i = 1; i <= K; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int dir = sc.nextInt() - 1;
            horses[i] = new Horse(r, c, dir);
            state[r][c].add(i);
        }

        System.out.println(start());

    }

    private static int start() {
        boolean flag = true;
        int times = 0;
        while (flag) {
            times++;
            if (times > 1000)
                break;

            for (int i = 1; i <= K; i++) {
                Horse h = horses[i];
                int r = h.r;
                int c = h.c;

                // ���� �Ʒ��� ���� �ƴ϶�� PASS
                if (state[r][c].get(0) != i)
                    continue;

                int nr = r + dr[h.dir];
                int nc = c + dc[h.dir];

                // ���� �̵��Ϸ��� ĭ�� �Ķ����� ��� + ü������ ����� ���
                if (!isRange(nr, nc) || map[nr][nc] == BLUE) {
                    // ���� �ݴ��
                    h.dir = change[h.dir];
                    nr = r + dr[h.dir];
                    nc = c + dc[h.dir];
                }

                // ������ �ݴ�� �� �Ŀ� �̵��Ϸ��� ĭ�� �Ķ����� ���
                if (!isRange(nr, nc) || map[nr][nc] == BLUE) {
                    continue;
                }
                // ���� �̵��Ϸ��� ĭ�� �������� ���
                else if (map[nr][nc] == RED) {
                    // ������ �ݴ�� ��� ���� �̵�
                    for (int j = state[r][c].size() - 1; j >= 0; j--) {
                        int tmp = state[r][c].get(j);
                        state[nr][nc].add(tmp);
                        horses[tmp].r = nr;
                        horses[tmp].c = nc;
                    }
                    state[r][c].clear();
                }
                // ���� �̵��Ϸ��� ĭ�� ����� ���
                else {
                    // ��� ���� �̵�
                    for (int j = 0; j < state[r][c].size(); j++) {
                        int tmp = state[r][c].get(j);
                        state[nr][nc].add(tmp);
                        horses[tmp].r = nr;
                        horses[tmp].c = nc;
                    }
                    state[r][c].clear();
                }

                // �̵��� ���� ���� 4�� �̻� �ִ°�?
                if (state[nr][nc].size() >= 4) {
                    flag = false;
                    break;
                }
            }
        }
        return flag ? -1 : times;
    }

    static boolean isRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
