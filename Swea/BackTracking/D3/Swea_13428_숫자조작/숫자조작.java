package Swea.BackTracking.D3.Swea_13428_숫자조작;

import java.io.*;
import java.util.*;

public class 숫자조작 {
    static String N;

    static long Min, Max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {

            N = br.readLine();

            Min = Long.parseLong(N);
            Max = Long.parseLong(N);

            dfs(0, N);

            sb.append("#").append(testCase).append(" ")
                    .append(Min).append(" ").append(Max).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int depth, String n) {
        if(n.charAt(0) == '0') return;

        if(depth == 1) {
            Max = Math.max(Max, Long.parseLong(n));
            Min = Math.min(Min, Long.parseLong(n));

            return;
        }

        for(int i = 0; i < n.length() - 1; i++) {
            for(int j = i + 1; j < n.length(); j++) {
                char[] chars = n.toCharArray();

                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;

                dfs(depth + 1, String.valueOf(chars));
            }
        }
    }
}
