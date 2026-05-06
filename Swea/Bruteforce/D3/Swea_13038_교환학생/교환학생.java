package Swea.Bruteforce.D3.Swea_13038_교환학생;

import java.io.*;
import java.util.*;

public class 교환학생 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[] A = new int[7];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 7; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            long minCnt = Integer.MAX_VALUE;
            for(int i = 0; i < 7; i++) {

                int idx = i;
                long cnt = 0;

                int n = 0;
                while(N > n) {
                    idx %= 7;

                    if(A[idx] == 1) {
                        n++;
                    }

                    cnt++;
                    idx++;
                }

                minCnt = Math.min(minCnt, cnt);
            }

            sb.append("#").append(testCase).append(" ").append(minCnt).append("\n");
        }

        System.out.print(sb);
    }
}
