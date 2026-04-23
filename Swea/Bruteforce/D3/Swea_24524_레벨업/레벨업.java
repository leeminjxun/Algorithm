package Swea.Bruteforce.D3.Swea_24524_레벨업;

import java.io.*;
import java.util.*;

public class 레벨업 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[] point = new int[N + 1];

            st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= N; i++) {
                point[i] = Integer.parseInt(st.nextToken());
            }

            int minSum = Integer.MAX_VALUE;

            for(int i = 2; i < N; i++) {
                int sum  = 0;

                for(int j = 2; j <= N; j++) {
                    if(i == j) {
                        continue;
                    }

                    if(i == j - 1) {
                        sum += Math.abs(point[j] - point[j - 2]);
                        continue;
                    }

                    sum += Math.abs(point[j] - point[j - 1]);
                }

                minSum = Math.min(minSum, sum);
            }

            sb.append(minSum).append("\n");
        }

        System.out.println(sb);
    }
}
