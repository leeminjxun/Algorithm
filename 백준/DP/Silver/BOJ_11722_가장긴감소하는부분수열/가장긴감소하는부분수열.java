package 백준.DP.Silver.BOJ_11722_가장긴감소하는부분수열;

import java.io.*;
import java.util.*;

public class 가장긴감소하는부분수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N + 1];
        int[] dp = new int[N + 1];

        Arrays.fill(dp, 1);

        int max = 1;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            seq[i] = value;

            for(int j = 1; j < i; j++) {
                if(seq[j] > seq[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(dp[i], max);
        }

        System.out.println(max);



    }
}
