package 백준.Greedy.Silver.BOJ_11047_동전0;

import java.io.*;
import java.util.*;

public class 동전0 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            int price = Integer.parseInt(br.readLine());

            if(price > K) break;

            stack.push(price);
        }

        int minCnt = 0;

        while(!stack.isEmpty()) {
            int coin = stack.pop();

            minCnt += K / coin;
            K %= coin;

            if(K == 0) break;
        }

        System.out.println(minCnt);


    }
}
