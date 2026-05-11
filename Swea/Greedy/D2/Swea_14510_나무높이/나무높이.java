package Swea.Greedy.D2.Swea_14510_나무높이;

import java.io.*;
import java.util.*;

public class 나무높이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            int max = 0;

            int[] trees = new int[N];
            for(int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());

                max = Math.max(max, trees[i]);
            }
            int odd = 0;
            int even = 0;

            for(int i = 0; i < N; i++) {
                int diff = max - trees[i];

                even += diff / 2;
                odd += diff % 2;
            }

            // 균형 맞추기
            if(even > odd) {
                while(Math.abs(even - odd) > 1) {
                    even--;
                    odd += 2;
                }
            }

            int day = 0;

            if(even > odd) {
                day = even * 2;
            } else if(even < odd) {
                day = (odd * 2) - 1;
            } else {
                day = odd + even;
            }

            sb.append("#").append(testCase).append(" ").append(day).append("\n");
        }

        System.out.println(sb);
    }
}
