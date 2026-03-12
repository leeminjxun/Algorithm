package 백준.구현.Sliver;

import java.io.*;
import java.util.*;

public class BOJ_14467_소가길을건너간이유1 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10];
        int cnt = 0;

        for(int i = 0; i < 10; i++) {
            arr[i] = 2;
        }


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int pos = Integer.parseInt(st.nextToken());

            if(arr[num] != 0 && arr[num] != 1) {
                arr[num] = pos;
                continue;
            }

            if(arr[num] != pos) {
                arr[num] = pos;
                cnt++;
            }

        }

        System.out.println(cnt);


    }
}
