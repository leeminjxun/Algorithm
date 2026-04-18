package Swea.Greedy.D3.Swea_1289_원재의메모리복구하기;

import java.io.*;
import java.io.*;

public class 원재의메모리복구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            String memo = br.readLine();

            char next = '0';

            int cnt = 0;

            for(int i = 0; i < memo.length(); i++) {
                if(memo.charAt(i) != next) {
                    cnt++;

                    if(next == '0') {
                        next = '1';
                    } else {
                        next = '0';
                    }
                }
            }

            sb.append("#" + testCase + " " + cnt + "\n");
        }

        System.out.println(sb);
    }
}
