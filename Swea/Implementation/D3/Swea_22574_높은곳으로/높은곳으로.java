package Swea.Implementation.D3.Swea_22574_높은곳으로;

import java.io.*;
import java.util.*;

public class 높은곳으로 {
    static long[] sum = new long[2001];

    static void initSum() {
        sum[0] = 0;
        for(int i = 1; i <= 2000; i++) {
            sum[i] += sum[i - 1] + i;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        initSum();

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            boolean isBoom = false;
            for(int i = 1; i <= N; i++) {
                if(sum[i] == P) {
                    isBoom = true;
                    break;
                }
            }

            sb.append(isBoom ? sum[N] - 1 : sum[N]).append("\n");
        }

        System.out.print(sb);
    }
}
