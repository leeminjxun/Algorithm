package 백준;
import java.io.*;
import java.util.*;

public class Test {
    static class Hint {
        String number;
        int strike;
        int ball;

        Hint(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

    static int N;

    static List<Hint> h;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        h = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            h.add(new Hint(st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        int res = 0;

        for(int i = 123; i<= 987; i++) {
            boolean isMatch = true;

            if(!valid(String.valueOf(i))) continue;

            for(Hint hint : h) {
                if(!check(String.valueOf(i), hint)) {
                    isMatch = false;
                    break;
                }
            }

            if(isMatch) res++;
        }

        System.out.println(res);
    }

    static boolean valid(String candidate) {
        int a = candidate.charAt(0);
        int b = candidate.charAt(1);
        int c = candidate.charAt(2);

        if(a == '0' || b == '0' || c == '0') return false;

        if(a == b || b == c || c == a) return false;

        return true;
    }

    static boolean check(String candidate, Hint hint) {
        int sCnt = 0;
        int bCnt = 0;

        for(int i = 0; i < 3; i++) {
            if(candidate.charAt(i) == hint.number.charAt(i)) sCnt++;

            else if(candidate.contains(String.valueOf(hint.number.charAt(i)))) bCnt++;
        }

        return sCnt == hint.strike && bCnt == hint.ball;
    }
}
