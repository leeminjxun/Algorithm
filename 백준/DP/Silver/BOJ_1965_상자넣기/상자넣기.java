package 백준.DP.Silver.BOJ_1965_상자넣기;

import java.io.*;
import java.util.*;

public class 상자넣기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] box = new int[N];
        int[] dp = new int[N];

        Arrays.fill(dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(box[i] > box[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
