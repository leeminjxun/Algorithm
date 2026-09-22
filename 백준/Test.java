package 백준;
import java.io.*;
import java.util.*;

public class Test {
    static class Base {
        String num;
        int strike;
        int ball;

        Base(String num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Base> baseList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            baseList.add(new Base(st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        int cnt = 0;

        for(int i = 123; i <= 987; i++) {
            if(!isValid(String.valueOf(i))) continue;

            boolean isPossible = true;

            for(Base base : baseList) {
                if(!check(String.valueOf(i), base)) isPossible = false;
            }

            if(isPossible) cnt++;

        }

        System.out.println(cnt);

    }

    static boolean isValid(String num) {
        int a = num.charAt(0);
        int b = num.charAt(1);
        int c = num.charAt(2);

        return a != b && b != c && c != a;
    }

    static boolean check(String num, Base base) {
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < 3; i++) {
            if(num.charAt(i) == base.num.charAt(i)) strike++;
            else if(base.num.contains(String.valueOf(num.charAt(i)))) ball++;
        }


        return base.strike == strike && base.ball == ball;
    }
}
