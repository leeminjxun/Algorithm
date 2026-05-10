package Swea;

import java.io.*;
import java.util.*;

public class Test {
    static String num;
    static int change, N, max;
    static char[] digit;

    static Set<String>[] set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            num = st.nextToken();
            change = Integer.parseInt(st.nextToken());

            digit = num.toCharArray();
            N = num.length();

            max = 0;

            set = new HashSet[change + 1];

            for(int i = 0; i <= change; i++) {
                set[i] = new HashSet<>();
            }
            dfs(0, num);

            sb.append("#").append(testCase).append(" ").append(max).append("\n");

        }

        System.out.print(sb);
    }

    static void dfs(int depth, String num) {
        if(set[depth].contains(num)) return;
        set[depth].add(num);

        if(depth == change) {
            max = Math.max(max, Integer.parseInt(num));
            return;
        }


        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                dfs(depth + 1, changeNum(num, i, j));
            }
        }

    }

    static String changeNum(String num, int i, int j) {
        char[] digit = num.toCharArray();

        char temp = digit[i];
        digit[i] = digit[j];
        digit[j] = temp;

        return String.valueOf(digit);
    }
}
