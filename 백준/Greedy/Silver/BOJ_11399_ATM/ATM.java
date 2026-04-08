package 백준.Greedy.Silver.BOJ_11399_ATM;

import java.io.*;
import java.util.*;

public class ATM {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] atm = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            atm[i]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(atm);

        int sum = atm[1];

        for(int i = 1; i < N; i++) {
            atm[i] += atm[i - 1];

            sum += atm[i];
        }

        System.out.println(sum);
    }
}
