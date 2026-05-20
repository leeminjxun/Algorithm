package 백준;
import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        if(N < 3) {
            System.out.print(N);
            return;
        }

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int res = 2;

        // i 는 가장 작은 두 수 a 와 b
        // j 는 가장 큰 수 c 를 나타낸다.

        for(int i = 0; i < N - 1; i++) {
            for(int j = N - 1; j > i + 2; j--) {
                if(A[i] + A[i + 1] > A[j]) {
                    res = Math.max(res, j - i + 1);
                    break;
                }
            }
        }

        System.out.print(res);

    }
}
