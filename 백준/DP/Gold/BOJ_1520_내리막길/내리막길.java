package 백준.DP.Gold.BOJ_1520_내리막길;

import java.io.*;
import java.util.*;

public class 내리막길 {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int row;
    static int col;

    static int[][] map;
    static long[][] dp;

    static long H;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        dp = new long[row][col];

        for(int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(long[] row : dp) Arrays.fill(row, -1);

        System.out.println(DFS(0, 0));

    }

    static long DFS(int r, int c) {

        if(r == row - 1 && c == col - 1) {
            return 1;
        }

        if(dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = 0;

        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nc < 0 || nr >= row || nc >= col) continue;
            if(map[r][c] <= map[nr][nc]) continue;

            dp[r][c] += DFS(nr, nc);
        }

        return dp[r][c];
    }
}
