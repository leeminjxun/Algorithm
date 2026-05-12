package Swea.Greedy.D2.Swea_1859_백만장자프로젝트;

import java.io.*;
import java.util.*;

public class 백만장자프로젝트 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[] cost = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            long profit = 0;
            int exp = 0;

            for(int i = N - 1; i >= 0; i--) {
                if(cost[i] > exp) {
                    exp = cost[i];
                }

                if(cost[i] < exp) {
                    profit += (exp - cost[i]);
                }
            }

            sb.append("#").append(testCase).append(" ").append(profit).append("\n");
        }

        System.out.print(sb);
    }
}
