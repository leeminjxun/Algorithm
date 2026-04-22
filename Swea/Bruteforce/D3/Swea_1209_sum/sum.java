package Swea.Bruteforce.D3.Swea_1209_sum;

import java.io.*;
import java.util.*;

public class sum {
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= 10; testCase++) {
            int T = Integer.parseInt(br.readLine());

            arr = new int[100][100];

            for(int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;

            int rowSum = 0;
            int colSum = 0;

            // 대각선
            int diaSum = 0;
            int reverseDiaSum = 0;
            for(int i = 0; i < 100; i++) {
                diaSum += arr[i][i];
                reverseDiaSum += arr[i][99 - i];

                rowSum = 0;
                colSum = 0;
                for(int j = 0; j < 100; j++) {
                    rowSum += arr[i][j];
                    colSum += arr[j][i];
                }

                max = Math.max(max, Math.max(rowSum, colSum));
            }

            max = Math.max(max, Math.max(diaSum, reverseDiaSum));

            sb.append("#").append(T).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }
}
