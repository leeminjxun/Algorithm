package 백준.implementation.Silver.BOJ_4396_지뢰찾기;

import java.io.*;
import java.util.*;

public class 지뢰찾기 {
    static int N;

    static int[] dr = {0, 1, 0, -1, -1, 1, 1, -1};
    static int[] dc = {1, 0, -1, 0, 1, -1, 1, -1};

    static char[][] game;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        game = new char[N][N];
        char[][] board = new char[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                game[i][j] = s.charAt(j);
            }
        }

        for(char[] b : board) {
            Arrays.fill(b, '.');
        }

        boolean isPutTheBomb = false;

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                if(s.charAt(j) == 'x') {
                    if(game[i][j] == '*') isPutTheBomb = true;

                    board[i][j] = (char)(search(i, j) + '0');
                }
            }
        }

        if(isPutTheBomb) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(game[i][j] == '*') board[i][j] = '*';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char[] row : board) {
            for(char col : row) {
                sb.append(col);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static int search(int row, int col) {
        int cnt = 0;

        for(int i = 0; i < 8; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

            if(game[nr][nc] == '*') cnt++;
        }

        return cnt;

    }
}
