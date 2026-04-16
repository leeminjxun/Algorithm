package 백준.bruteforce.Silver.BOJ_16937_두스티커;

import java.io.*;
import java.util.*;

public class 두스티커 {
    static int H, W, N, maxArea;

    static int[][] stickers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());

        stickers = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            stickers[i][0] = Integer.parseInt(st.nextToken());
            stickers[i][1] = Integer.parseInt(st.nextToken());
        }

        maxArea = 0;

        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                maxArea = Math.max(maxArea, solve(i, j));
            }
        }

        System.out.println(maxArea);
    }

    static int solve(int i, int j) {
        int r1 = stickers[i][0];
        int c1 = stickers[i][1];
        int r2 = stickers[j][0];
        int c2 = stickers[j][1];

        int area = (r1 * c1) + (r2 * c2);

        if(canAttach(r1, c1, r2, c2)) return area;
        if(canAttach(c1, r1, r2, c2)) return area;
        if(canAttach(r1, c1, c2, r2)) return area;
        if(canAttach(c1, r1, c2, r2)) return area;

        return 0;
    }

    static boolean canAttach(int h1, int w1, int h2, int w2) {
        // 두 스티커를 세로 로 놓는 경우
        if(Math.max(h1, h2) <= H && w1 + w2 <= W) return true;

        // 두 스티커를 가로 로 놓는 경우
        if(h1 + h2 <= H && Math.max(w1, w2) <= W) return true;

        return false;
    }

}
