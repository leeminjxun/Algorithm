package 백준.bruteforce.Silver.BOJ_1748_수이어쓰기1;

import java.io.*;
import java.util.*;

// 5 -> 5
// 15 -> 9 + (15-9) * 2
// 120 -> 9 + 90 * 2 + (120-99) * 3

public class 수이어쓰기1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int Num  = Integer.parseInt(s);

        // Num 의 자릿수 저장
        int size = s.length();

        // 이어붙힌 수의 길이
        int Len = 0;
        // 지나온 숫자를 나타내는 변수
        int seqNum = 0;
        // 제곱을 나타내는 수
        int pow = 1;

        for(int i = 0; i < size - 1; i++) {
            Len += 9 * pow * (i + 1);
            seqNum += 9 * pow;
            pow *= 10;
        }

        Len += (Num - seqNum) * size;

        System.out.println(Len);

    }
}
