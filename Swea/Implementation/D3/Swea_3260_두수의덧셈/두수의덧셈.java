package Swea.Implementation.D3.Swea_3260_두수의덧셈;

import java.io.*;
import java.util.*;

public class 두수의덧셈 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            StringBuilder a = new StringBuilder(st.nextToken()).reverse();
            StringBuilder b = new StringBuilder(st.nextToken()).reverse();

            String A = a.toString();
            String B = b.toString();

            StringBuilder result = new StringBuilder();

            int max = Math.max(A.length(), B.length());

            int temp = 0;
            for(int i = 0; i < max; i++) {
                int sum = 0;
                if(A.length() > i) {
                    sum += Integer.parseInt(String.valueOf(A.charAt(i)));
                }
                if(B.length() > i) {
                    sum += Integer.parseInt(String.valueOf(B.charAt(i)));
                }
                sum += temp;

                if(sum >= 10) {
                    result.append(sum - 10);
                    temp = 1;
                } else {
                    result.append(sum);
                    temp = 0;
                }
            }

            if(temp == 1) result.append(temp);

            sb.append("#").append(testCase).append(" ").append(result.reverse()).append("\n");
        }

        System.out.print(sb);
    }
}
