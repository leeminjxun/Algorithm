package 백준.bruteforce.Gold.BOJ_1548_부분삼각수열;

import java.io.*;
import java.util.*;

public class 부분삼각수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        if(N < 3) {
            System.out.println(N);
            return;
        }

        int[] A = new int[N];

        int res = 2;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for(int i = 0; i < N - 1; i++) {
            for(int j = N - 1; j >= i + 2; j--) {

                if(A[i] + A[i + 1] > A[j]) {
                    res = Math.max(res, j - i + 1);
                    break;
                }
            }
        }

        System.out.println(res);
    }
}
