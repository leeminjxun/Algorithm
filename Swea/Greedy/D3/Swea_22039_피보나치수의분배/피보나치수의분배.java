package Swea.Greedy.D3.Swea_22039_피보나치수의분배;

import java.io.*;
import java.util.*;

public class 피보나치수의분배 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            if(N % 3 == 1) {
                sb.append("impossible").append("\n");
                continue;
            }

            if(N % 3 == 2) {
                sb.append("BA");
                N -= 2;
            }

            while(N > 0) {
                sb.append("BBA");
                N -= 3;
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
