package Swea.Bruteforce.D3.Swea_7102_준홍이의카드놀이;

import java.io.*;
import java.util.*;

public class 준홍이의카드놀이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] sum = new int[N + M + 1];

            int max = 0;

            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    sum[i + j]++;

                    max = Math.max(max, sum[i + j]);
                }
            }

            List<Integer> list = new ArrayList<>();

            for(int i = 1; i <= N + M; i++) {
                if(sum[i] == max) list.add(i);
            }

            Collections.sort(list);

            sb.append("#").append(testCase);
            for(int i : list) {
                sb.append(" ").append(i);
            }
            sb.append("\n");

        }

        System.out.print(sb);
    }
}
