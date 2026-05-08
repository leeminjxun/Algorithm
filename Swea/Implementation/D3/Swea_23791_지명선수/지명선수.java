package Swea.Implementation.D3.Swea_23791_지명선수;

import java.io.*;
import java.util.*;

public class 지명선수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int n = Integer.parseInt(br.readLine());

            boolean[] player = new boolean[n + 1];

            int[] A = new int[n];
            int[] B = new int[n];

            char[] picked = new char[n + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            int aIdx = 0;
            int bIdx = 0;

            for(int turn = 0; turn < n; turn++) {
                if(turn % 2 == 0) {
                    while(aIdx < n && player[A[aIdx]]) aIdx++;
                    player[A[aIdx]] = true;
                    picked[A[aIdx]] = 'A';
                } else {
                    while(bIdx < n && player[B[bIdx]]) bIdx++;
                    player[B[bIdx]] = true;
                    picked[B[bIdx]] = 'B';
                }
            }

            for(int i = 1; i <= n; i++) {
                sb.append(picked[i]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
