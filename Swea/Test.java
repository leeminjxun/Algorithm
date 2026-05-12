package Swea;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[] lectures = new int[7];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 7; i++) {
                lectures[i] = Integer.parseInt(st.nextToken());
            }

            int minRes = Integer.MAX_VALUE;
            int weekend = 0;

            for(int day = 0; day < 7; day++) {
                int lc = N;
                int now = day;

                int res = 0;
                while(lc > 0) {
                    if(lectures[now] == 1) {
                        lc--;
                    }

                    now = (now + 1) % 7;
                    res++;
                }

                minRes = Math.min(minRes, res);
            }

            sb.append("#").append(testCase).append(" ").append(minRes).append("\n");
        }

        System.out.print(sb);
    }
}
