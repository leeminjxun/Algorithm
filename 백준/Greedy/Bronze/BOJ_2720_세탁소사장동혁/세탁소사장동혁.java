package 백준.Greedy.Bronze.BOJ_2720_세탁소사장동혁;

import java.io.*;
import java.util.*;

public class 세탁소사장동혁 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 0; testCase < T; testCase++) {
            int price = Integer.parseInt(br.readLine());

            // Q : 25, D : 10, N = 5, P = 1

            int Q = 0, D = 0, N = 0, P = 0;

            Q = price / 25;
            price -= 25 * Q;

            D = price / 10;
            price -= 10 * D;

            N = price / 5;
            price -= 5 * N;

            P = price;


            sb.append(Q + " " + D + " " + N + " " + P);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
