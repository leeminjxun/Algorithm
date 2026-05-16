package Swea.TwoPointer.Swea_7510_상원이의연속합;

import java.io.*;
import java.util.*;

public class 상원이의연속합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int start = 1;
            int end = 1;
            int sum = 1;

            int ans = 0;

            while(start <= N) {
                if(sum == N) {
                    ans++;
                    sum -= start;
                    start++;
                }

                else if(sum < N) {
                    end++;
                    sum += end;
                }

                else if(sum > N) {
                    sum -= start;
                    start++;
                }
            }

            sb.append("#").append(testCase).append(" ").append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
