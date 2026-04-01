package 백준;
import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] sw = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            sw[i] = Integer.parseInt(st.nextToken());
        }

        int T = Integer.parseInt(br.readLine());

        for(int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int sn = Integer.parseInt(st.nextToken());

            if(gender == 1) {
                for(int i = sn - 1; i < N; i += sn) {
                    sw[i] = 1 - sw[i];
                }
            } else {

                int mid = sn - 1;

                sw[mid] = 1 - sw[mid];

                int count = 1;

                while((mid - count) >= 0 && (mid + count) < N && sw[mid - count] == sw[mid + count]) {
                    sw[mid - count] = 1 - sw[mid - count];
                    sw[mid + count] = 1 - sw[mid + count];

                    count++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(sw[i]).append(" ");

            if((i + 1) % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }
}
