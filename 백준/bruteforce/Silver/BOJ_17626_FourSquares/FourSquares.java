package 백준.bruteforce.Silver.BOJ_17626_FourSquares;
import java.io.*;
import java.util.*;

public class FourSquares {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i = 1; i <= N; i++) {

            // i 를 기준으로 1, 4, 9, 16 만큼 뒤에 있는 값 중 가장 작은 원소를 택한 값만 올린다.
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
