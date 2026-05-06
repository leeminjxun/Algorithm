package Swea.Bruteforce.D3.Swea_5789_현주의상자바꾸기;

import java.io.*;
import java.util.*;

public class 현주의상자바꾸기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            int[] box = new int[N + 1];

            int[][] query = new int[Q + 1][2];

            for(int i = 1; i <= Q; i++) {
                st = new StringTokenizer(br.readLine());

                query[i][0] = Integer.parseInt(st.nextToken());
                query[i][1] = Integer.parseInt(st.nextToken());
            }

            for(int i = Q; i >= 1; i--) {
                int L = query[i][0];
                int R = query[i][1];

                for(int j = L; j <= R; j++) {
                    if(box[j] == 0) box[j] = i;
                }
            }

            sb.append("#").append(testCase);

            for(int i = 1; i <= N; i++) {
                sb.append(" ").append(box[i]);
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
