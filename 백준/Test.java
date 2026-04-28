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

    static List<Hint> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            list.add(new Hint(st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        int res = 0;

        for(int i = 123; i <= 987; i++) {
            boolean isMatch = true;

            if(!valid(i)) continue;

            for(int j = 0; j < N; j++) {
                Hint h = list.get(j);

                if(!check(String.valueOf(i), h)) {
                    isMatch = false;
                    break;
                }
            }

            if(isMatch) res++;
        }

        System.out.println(res);
    }

    static boolean check(String candidate, Hint hint) {
        int s = 0;
        int b = 0;

        for(int i = 0; i < 3; i++) {
            if(candidate.charAt(i) == hint.number.charAt(i)) s++;

            else if(hint.number.contains(String.valueOf(candidate.charAt(i)))) b++;
        }

        return s == hint.strike && b == hint.ball;
    }

    static boolean valid(int num) {
        String target = String.valueOf(num);

        char first = target.charAt(0);
        char second = target.charAt(1);
        char third = target.charAt(2);

        if(first == '0' || second == '0' || third == '0') return false;

        if(first == second || second == third || third == first) return false;

        return true;
    }
}
