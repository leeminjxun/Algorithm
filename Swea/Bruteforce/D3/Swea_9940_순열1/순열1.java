package Swea.Bruteforce.D3.Swea_9940_순열1;

import java.io.*;
import java.util.*;

public class 순열1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            int N = Integer.parseInt(br.readLine());

            HashSet<Integer> set = new HashSet<>();

            boolean check = true;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());

                if(set.contains(num)) {
                    check = false;
                    break;
                }

                set.add(num);
            }

            sb.append(check ? "Yes" : "No").append("\n");
        }

        System.out.print(sb);
    }
}
