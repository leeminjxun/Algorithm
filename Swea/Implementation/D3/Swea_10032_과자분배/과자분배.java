package Swea.Implementation.D3.Swea_10032_과자분배;

import java.io.*;
import java.util.*;

public class 과자분배 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if(K > N) {
                sb.append(1).append("\n");
                continue;
            } else {
                if(N % K == 0) sb.append(0).append("\n");
                else sb.append(1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
