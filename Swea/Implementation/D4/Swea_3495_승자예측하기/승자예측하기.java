package Swea.Implementation.D4.Swea_3495_승자예측하기;

import java.io.*;
import java.util.*;

public class 승자예측하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            long N = Long.parseLong(br.readLine());

            while(N > 3) {
                N = (N / 2) + 1;
                N = (N / 2) - 1;
            }

            if(N >= 2 || N == 0) sb.append("#").append(testCase).append(" ").append("Alice").append("\n");
            else sb.append("#").append(testCase).append(" ").append("Bob").append("\n");
        }

        System.out.print(sb);

    }
}
