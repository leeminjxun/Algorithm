package Swea.Implementation.D3.Swea_4615_재미있는오셀로게임;

import java.io.*;
import java.util.*;

public class 재미있는오셀로게임 {
    // 상, 하, 좌, 우 // 상좌, 상우, 하좌, 하우
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    static int N, M;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            board = new int[N][N];

            int center = (N - 1) / 2;

            // 백돌 배치
            board[center][center] = 2; board[center + 1][center + 1] = 2;
            // 흑돌 배치
            board[center + 1][center] = 1; board[center][center + 1] = 1;

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int c = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;
                int color = Integer.parseInt(st.nextToken());

                putTheDoll(r, c, color);
            }

            int black = 0;
            int white = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(board[i][j] == 1) black++;
                    else if(board[i][j] == 2) white++;
                }
            }

            sb.append("#").append(testCase).append(" ");
            sb.append(black).append(" ").append(white);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void putTheDoll(int r, int c, int color) {
        board[r][c] = color;

        for(int dir = 0; dir < 8; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N || board[nr][nc] == 0) continue;
            if(board[nr][nc] == color) continue;

            dfs(nr, nc, color, dir);
        }
    }

    static boolean dfs(int r, int c, int color, int dir) {

        int nr = r + dr[dir];
        int nc = c + dc[dir];

        // 범위를 넘어가거나, 다음 구간에 어떠한 돌도 놔지지 않은 경우
        if(nr < 0 || nc < 0 || nr >= N || nc >= N || board[nr][nc] == 0) return false;

        // 다음 돌이 시작 돌의 색과 같은 경우
        if(board[nr][nc] == color) {
            // 뒤집기
            board[r][c] = color;
            return true;
        }

        // 해당 구간의 돌을 뒤집어야한다는 결과가 나온 경우
        if(dfs(nr, nc, color, dir)) {
            board[r][c] = color;
            return true;
        }

        // 끝까지 시작 돌과 같은 색의 돌을 찾지 못함
        return false;
    }
}
