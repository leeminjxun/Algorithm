package 백준;
import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        int[] dp = new int[N + 2];

        StringTokenizer st;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for(int i = 1; i <= N + 1; i++) {
            max = Math.max(max, dp[i]);

            if(i == N + 1) continue;

            int endTime = i + T[i];

            if(endTime <= N + 1) {
                dp[endTime] = Math.max(dp[endTime], max + P[i]);
            }

        }

        System.out.println(max);

    }
}
