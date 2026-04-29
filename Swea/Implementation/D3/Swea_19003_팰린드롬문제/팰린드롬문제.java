package Swea.Implementation.D3.Swea_19003_팰린드롬문제;

import java.io.*;
import java.util.*;

public class 팰린드롬문제 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[] arr = new String[N];
            Set<String> set = new HashSet<>();

            for(int i = 0; i < N; i++) {
                arr[i] = br.readLine();
                set.add(arr[i]);
            }

            int cnt = 0;
            boolean hashCenter = false;

            for(int i = 0; i < N; i++) {
                String reversed = new StringBuilder(arr[i]).reverse().toString();

                if(arr[i].equals(reversed)) hashCenter = true;

                else if(set.contains(reversed)) cnt++;
            }

            int ans = cnt * M;

            if(hashCenter) ans += M;


            sb.append("#").append(testCase).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
