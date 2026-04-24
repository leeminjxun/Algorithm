package 백준.BackTracking.Gold.BOJ_16637_괄호추가하기;

import java.io.*;

public class 괄호추가하기 {
    static int N, max;
    static String S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = br.readLine();

        max = Integer.MIN_VALUE;

        dfs(0, S.charAt(0) - '0');

        System.out.println(max);
    }

    static void dfs(int idx, int current) {
        if(idx >= N - 1) {
            max = Math.max(max, current);
            return;
        }

        char op = S.charAt(idx + 1);
        int nextNum = S.charAt(idx + 2) - '0';

        int res = calculator(current, op, nextNum);
        dfs(idx + 2, res);

        if(idx + 4 < N) {
            char nextOp = S.charAt(idx + 3);
            int nextNextNum = S.charAt(idx + 4) - '0';

            int nextResult = calculator(nextNum, nextOp, nextNextNum);
            res = calculator(current, op, nextResult);
            dfs(idx + 4, res);
        }
    }

    static int calculator(int A, char op, int B) {
        int res = 0;

        if(op =='+') {
            res = A + B;
        } else if (op == '-') {
            res = A - B;
        } else if (op == '*') {
            res = A * B;
        }

        return res;
    }
}
