package Swea.Implementation.D3.Swea_7964_부먹왕국의차원관문;

import java.io.*;
import java.util.*;

public class 부먹왕국의차원관문 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int cnt = 0;

            int left = D;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int city = Integer.parseInt(st.nextToken());

                if(city == 1) left = D;
                else {
                    left--;
                    if(left == 0) {
                        cnt++;
                        left = D;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
