package Swea.BackTracking.D3.Swea_1244_최대상금;

import java.io.*;
import java.util.*;

public class 최대상금 {
    static int K;
    static String max;

    static Set<String>[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            String num = st.nextToken();
            K = Integer.parseInt(st.nextToken());

            visited = new HashSet[K + 1];

            for(int i = 0; i <= K; i++) {
                visited[i] = new HashSet<>();
            }

            max = "0";

            dfs(num, 0);

            sb.append("#" + testCase + " " + max).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(String num, int cnt) {
        if(cnt == K) {
            if(max.compareTo(num) < 0) {
                max = num;
            }
            return ;
        }

        if(visited[cnt].contains(num)) return;
        visited[cnt].add(num);

        for(int i = 0; i < num.length() - 1; i++) {
            for(int j = i + 1; j < num.length(); j++) {
                dfs(change(num, i, j), cnt + 1);
            }
        }

    }

    static String change(String num , int i, int j) {
        char[] digit = num.toCharArray();

        char temp = digit[i];
        digit[i] = digit[j];
        digit[j] = temp;

        return String.valueOf(digit);
    }
}
