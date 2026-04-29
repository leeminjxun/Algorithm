package Swea.Implementation.D3.Swea_6485_삼성시의버스노선;

import java.io.*;
import java.util.*;

public class 삼성시의버스노선 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[] A = new int[N + 1];
            int[] B = new int[N + 1];

            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                A[i] = Integer.parseInt(st.nextToken());
                B[i] = Integer.parseInt(st.nextToken());
            }

            int P = Integer.parseInt(br.readLine());

            int[] busStop = new int[5001];

            for(int i = 1; i <= N; i++) {
                for(int j = A[i]; j <= B[i]; j++) {
                    busStop[j]++;
                }
            }

            int C = 0;

            sb.append("#").append(testCase);
            for(int i = 1; i <= P; i++) {
                C = Integer.parseInt(br.readLine());

                sb.append(" ").append(busStop[C]);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
