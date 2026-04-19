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

// 두번째 풀이

/**
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String S = br.readLine();
    String P = br.readLine();

    int idx = 0;
    int cnt = 0;

    for(int end = 0; end < P.length(); end++) {
        String subP = P.substring(idx, end + 1);

        if(S.contains(subP)) continue;
        idx = end;
        cnt++;

    }

    // + 1 을 하는 이유는 문자열을 나누면서 end + 1 으로 마지막 문자열을 계산하지 않기 때문이다.
    System.out.println(cnt + 1);
}*/
