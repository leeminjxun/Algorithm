package 백준.bruteforce.Bronze.BOJ_2231_분해합;

import java.io.*;
import java.util.*;

public class 분해합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int start = Math.max(1, N - 9 * String.valueOf(N).length());

        for(int i = start; i < N; i++) {
            int sum = i;
            int temp = i;

            while(temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if(sum == N) {
                System.out.println(i);
                return ;
            }
        }

        System.out.println(0);
    }
}
