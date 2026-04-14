package 백준.bruteforce.Bronze.BOJ_18312_시각;

import java.io.*;
import java.util.*;

public class 시각 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String K = st.nextToken();

        int cnt = 0;

        for(int h = 0; h <= N; h++) {
            for(int m = 0; m < 60; m++) {
                for(int s = 0; s < 60; s++) {
                    String time = String.format("%02d%02d%02d", h, m, s);

                    if(time.contains(K)) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
