package Swea.Greedy.D3.Swea_17642_최대조작횟수;

import java.io.*;
import java.util.*;

public class 최대조작횟수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            sb.append("#").append(testCase).append(" ");

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if(a == b) {
                sb.append("0").append("\n");
                continue;
            }

            long diff = b - a;

            if(diff <= 1) sb.append("-1");
            else sb.append(diff / 2);

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
