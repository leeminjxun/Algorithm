package 백준.Greedy.Silver.BOJ_2839_설탕배달;

import java.io.*;
import java.util.*;

public class 설탕배달 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        while(true) {
            if(N % 5 == 0) {
                count += N / 5;
                System.out.println(count);
                break;
            }

            N -= 3;
            count++;

            if(N < 0) {
                System.out.println("-1");
                break;
            }
        }

    }
}
