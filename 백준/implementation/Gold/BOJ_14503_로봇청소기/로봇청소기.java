package 백준.implementation.Gold.BOJ_14503_로봇청소기;

import java.io.*;
import java.util.*;

public class 로봇청소기 {
    // 북, 동, 남, 서
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < M; col++) {
                room[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        while(true) {
            if(room[r][c] == 0) {
                room[r][c] = 2;
                count++;
            }

            // 주변 4 공간이 깨끗한지 check
            boolean isClean = true;
            for(int i = 0; i < 4; i++) {
                d =  (d + 3) % 4;

                int nr = r + dr[d];
                int nc = c + dc[d];

                if(room[nr][nc] == 0) {
                    isClean = false;
                    r = nr;
                    c = nc;
                    break;
                }
            }

            if(isClean) {
                r -= dr[d];
                c -= dc[d];

                if(r < 0 || c < 0 || r >= N || c >= M) break;
                if(room[r][c] == 1) break;
            }
        }

        System.out.println(count);
    }
}


