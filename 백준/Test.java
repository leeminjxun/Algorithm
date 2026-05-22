package 백준;
import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String S = br.readLine();
        String P = br.readLine();

        int idx = 0;
        String target = "";

        int cnt = 0;

        while(idx < P.length()) {
            target += String.valueOf(P.charAt(idx));

            if(!S.contains(target)) {
                target = "";
                cnt++;
            } else {
                idx++;
            }
        }

        System.out.println(cnt + 1);

    }
}
