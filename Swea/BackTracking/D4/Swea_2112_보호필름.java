package Swea.BackTracking.D4;

import java.io.*;
import java.util.*;

public class Swea_2112_보호필름 {
    static int D, W, K, res;
    static int[][] film;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            film = new int[D][W];

            for(int i = 0; i < D; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = Integer.MAX_VALUE;

            DFS(0, 0);

            sb.append("#").append(testCase).append(" ").append(res).append("\n");
        }
        System.out.print(sb);
    }

    static void DFS(int idx, int cnt) {
        if(cnt >= res) return;

        if(check()) {
            res = cnt;
            return;
        }

        if(idx == D) return;

        // 변경하지 않음
        DFS(idx + 1, cnt);

        int[] backup = film[idx].clone();

        // 1 으로 변경
        change(idx, 1);
        DFS(idx + 1, cnt + 1);

        // 0 으로 변경
        change(idx, 0);
        DFS(idx + 1, cnt + 1);

        film[idx] = backup;
    }

    static boolean check() {
        for(int i = 0; i < W; i++) {
            int seqCnt = 0;
            int cnt = 0;
            int offset = 0;

            for(int j = 0; j < D; j++) {
                if(film[j][i] != offset) {
                    seqCnt = Math.max(seqCnt, cnt);
                    cnt = 0;
                    offset = 1 - offset;
                }

                if(film[j][i] == offset) {
                    cnt++;
                }
            }

            seqCnt = Math.max(seqCnt, cnt);

            if(seqCnt < K) return false;
        }
        return true;
    }

    static void change(int idx, int number) {
        for(int j = 0; j < W; j++) {
            film[idx][j] = number;
        }
    }
}
