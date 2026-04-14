package 백준.bruteforce.Silver.BOJ_1969_DNA;

import java.io.*;
import java.util.*;

public class DNA {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] DNA = new String[N];

        for(int i = 0; i < N; i++) {
            DNA[i] = br.readLine();
        }

        StringBuilder res = new StringBuilder();
        int totalSum = 0;
        for(int i = 0; i < M; i++) {
            int[] count = new int[4];

            for(int j = 0; j < N; j++) {
                char c = DNA[j].charAt(i);

                if(c =='A') count[0]++;
                if(c =='C') count[1]++;
                if(c =='G') count[2]++;
                if(c =='T') count[3]++;
            }

            int maxIdx = 0;
            int maxCount = 0;

            for(int j = 0; j < 4; j++) {
                if(maxCount < count[j]) {
                    maxIdx = j;
                    maxCount = count[j];
                }
            }

            res.append(getChar(maxIdx));
            totalSum += (N - maxCount);

        }

        System.out.println(res);
        System.out.println(totalSum);

    }

    static char getChar(int idx) {

        if(idx == 0) return 'A';
        if(idx == 1) return 'C';
        if(idx == 2) return 'G';

        return 'T';
    }
}
