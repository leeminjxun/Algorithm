package 백준.Greedy.Bronze.BOJ_10162_전자레인지;
import java.io.*;
import java.util.*;

public class 전자레인지 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // 5분 = 300
        // 1분 = 60
        // 10

        int A = 0;
        A = T / 300;
        T = T % 300;

        int B = 0;
        B = T / 60;
        T = T % 60;

        int C = 0;
        C = T / 10;
        T = T % 10;

        if(T != 0) {
            System.out.println("-1");
            return ;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(A).append(" ").append(B).append(" ").append(C);


        System.out.println(sb);
    }
}
