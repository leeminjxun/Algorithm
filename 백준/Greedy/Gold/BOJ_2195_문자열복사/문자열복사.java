package 백준.Greedy.Gold.BOJ_2195_문자열복사;

import java.io.*;
import java.util.*;

public class 문자열복사 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        int idx = 0;
        int cnt = 0;

        while(idx < P.length()) {
            int maxLen = 0;

            for(int end = idx + 1; end <= P.length(); end++) {
                String subP = P.substring(idx, end);

                if(S.contains(subP)) {
                    maxLen = end - idx;
                } else {
                    break;
                }

            }

            idx++;
            cnt++;
        }

        System.out.println(cnt);
    }
}
