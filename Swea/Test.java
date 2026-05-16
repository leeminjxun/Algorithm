package Swea;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder() ;
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int sum = 1;
            int start = 1;
            int end = 1;

            int cnt = 0;

            while(start <= N) {
                if(sum > N) {
                    sum -= start;
                    start++;
                } else if(sum < N) {
                    end++;
                    sum += end;
                } else {
                    cnt++;

                    sum -= start;
                    start++;
                }
            }

            sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
