package Swea;

import java.io.*;
import java.util.*;

public class Test {
    static int[] dr = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dc = {-1, 1, 0, 0, -1, 1, -1, 1};

    static int N;

    static String[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {

            N = Integer.parseInt(br.readLine());

            map = new String[N][N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = st.nextToken();
                }
            }

            int max = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j].equals("B")) {
                        // 8 방향에 건물이 존재
                        if(search(i, j)) {
                            max = Math.max(max, calcHeight(i, j));
                        } else {
                            max = Math.max(max, 2);
                        }
                    }
                }
            }

            sb.append("#").append(testCase).append(" ").append(max).append("\n");
        }

        System.out.print(sb);

    }

    static boolean search(int r, int c) {
        for(int dir = 0; dir < 8; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

            if(map[nr][nc].equals("G")) return false;
        }

        return true;
    }

    static int calcHeight(int r, int c) {
        int height = 0;

        for(int i = 0; i < N; i++) {
            if(map[r][i].equals("B")) height++;

            if(map[i][c].equals("B")) height++;
        }

        return height - 1;
    }
}