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
            String init = br.readLine();

            int bit = 0;
            int cnt = 0;

            for(int i = 0; i < init.length(); i++) {
                if(Integer.parseInt(String.valueOf(init.charAt(i))) != bit) {
                    cnt++;
                    bit = 1 - bit;
                }
            }

            sb.append("#").append(testCase).append(" ").append(cnt);
        }

        System.out.print(sb);
    }
}
