package 백준.완전탐색.Sliver;

import java.io.*;
import java.util.*;

public class BOJ_6064_카잉달력 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            // 종말의 해 (x:y)
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int year = x;
            int result = -1;

            while(year <= M * N) {
                if(year % N == y % N) {
                    result = year;
                    break;
                }
                year += M;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
