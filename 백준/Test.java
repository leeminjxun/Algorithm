package 백준;
import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 소 번호 1 ~ 10
        int[] cow = new int[11];

        Arrays.fill(cow, -1);

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        StringTokenizer st;
        for(int testCase = 0; testCase < N; testCase++) {
            st = new StringTokenizer(br.readLine());

            int cowNum = Integer.parseInt(st.nextToken());
            int cowPos = Integer.parseInt(st.nextToken());

            if(cow[cowNum] == -1) {
                cow[cowNum] = cowPos;
            } else {
                if(cow[cowNum] != cowPos) {
                    cow[cowNum] = cowPos;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
