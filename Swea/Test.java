package Swea;

import java.io.*;
import java.util.*;

public class Test {
    static int N, res, totalSum;
    static int[] arr;

    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[] trees = new int[N];

            int maxH = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, trees[i]);
            }

            int even = 0;
            int odd = 0;

            for(int i = 0; i < N; i++) {
                int diff = maxH - trees[i];

                even += diff / 2;
                odd += diff % 2;
            }

            if(even > odd) {
                while(Math.abs(even - odd) > 1) {
                    even--;
                    odd += 2;
                }
            }

            sb.append("#").append(testCase).append(" ");

            if(even > odd) {
                sb.append(even * 2);
            } else if(even < odd) {
                sb.append(odd * 2 - 1);
            } else {
                sb.append(even + odd);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

}
