package Swea.Bruteforce.D3.Swea_20728_공평한분배2;

import java.io.*;
import java.util.*;

public class 공평한분배2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Long[] A = new Long[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                A[i] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(A);

            Long min = Long.MAX_VALUE;

            for(int i = 0; i <= N - K; i++) {
                min = Math.min(min, A[i + K - 1] - A[i]);
            }

            sb.append("#").append(testCase).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
    }
}
