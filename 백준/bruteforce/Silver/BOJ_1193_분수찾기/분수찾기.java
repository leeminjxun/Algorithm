package 백준.bruteforce.Silver.BOJ_1193_분수찾기;

import java.io.*;
import java.util.*;

public class 분수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int a = 1;
        int b = 1;
        int step = 1;
        while(true) {
            if(a <= X && X <= b) {
                break;
            }
            step++;

            a = b + 1;
            b += step;
        }

        int A = step - (b - X);

        int B = step - (X - a);

        if(step % 2 != 0) {
            // 홀수 일 경우
            System.out.println(B + "/" + A);
        } else {
            System.out.println(A + "/" + B);
        }

    }
}
