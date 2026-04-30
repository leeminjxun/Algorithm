package Swea.Bruteforce.D3.Swea_4698_테네스의특별한소수;

import java.io.*;
import java.util.*;

public class 테네스의특별한소수 {
    static int Max = 1000000;
    static boolean[] isPrime = new boolean[Max + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        makePrime();

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            st = new StringTokenizer(br.readLine());

            int D = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int res = 0;

            for(int i = A; i <= B; i++) {
                if(isPrime[i] && String.valueOf(i).contains(String.valueOf(D))) {
                    res++;
                }
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    static void makePrime() {
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i * i <= Max; i++) {
            for(int j = i * i; j <= Max; j += i) {
                if(isPrime[j]) {
                    isPrime[j] = false;
                }
            }
        }
    }

}
