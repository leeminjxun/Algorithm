package Swea.Implementation.D3.Swea_16800_구구단걷기;

import java.io.*;
import java.util.*;

public class 구구단걷기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            long N = Long.parseLong(br.readLine());

            long A = 0;
            long B = 0;

            for(long i = 1; i <= (long)Math.sqrt(N) + 1; i++) {
                if(N % i == 0) {
                    A = i;
                    B = N / i;
                }
            }

            sb.append("#").append(testCase).append(" ").append(A + B - 2).append("\n");
        }

        System.out.println(sb);
    }
}
