package 백준.bruteforce.Silver.BOJ_2503_숫자야구;

import java.io.*;
import java.util.*;

public class 숫자야구 {

    static class Hint {
        String number;

        int strike, ball;

        Hint(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Hint> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            list.add(new Hint(st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        int ans = 0;

        for(int i = 123; i <= 987; i++) {
            if(!valid(i)) continue;

            String candidate = String.valueOf(i);
            boolean isMatching = true;

            for(Hint h : list) {
                if(!check(candidate, h)) {
                    isMatching = false;
                    break;
                }
            }

            if(isMatching) ans++;
        }

        System.out.println(ans);
    }

    static boolean valid(int num) {
        String s = String.valueOf(num);

        char A = s.charAt(0);
        char B = s.charAt(1);
        char C = s.charAt(2);
        // 숫자 안에 0 이 들어가거나, 같은 숫자가 존재하면 not valid
        if(A == '0' || B == '0' || C == '0') return false;

        if(A == B || B == C || C == A) return false;

        return true;
    }

    static boolean check(String candidate, Hint h) {
        int sCount = 0;
        int bCount = 0;

        for(int i = 0; i < 3; i++) {
            // 1. 우선 스트라이크인지 확인
            if(candidate.charAt(i) == h.number.charAt(i)) sCount++;
            // 2. 스트라이크가 아닐 때만 볼 인지 확인한다. (else 필수)
            else if(h.number.contains(String.valueOf(candidate.charAt(i)))) bCount++;
        }

        return sCount == h.strike && bCount == h.ball;
    }
}
