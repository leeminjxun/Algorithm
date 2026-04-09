package 백준.Greedy.Gold.BOJ_1744_수묶기;

import java.io.*;
import java.util.*;

public class 수묶기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        boolean isZero = false;

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num > 0) plus.add(num);

            if(num <= 0) minus.add(num);
        }

        int res = 0;

        while(!plus.isEmpty()) {

            if(plus.size() == 1) {
                res += plus.poll();
                break;
            }

            int num1 = plus.poll();
            int num2 = plus.poll();

            if(num1 == 1 || num2 == 1) {
                res += num1 + num2;
            } else {
                res += num1 * num2;
            }
        }

        while(!minus.isEmpty()) {
            if(minus.size() == 1) {
                res += minus.poll();
                break;
            }

            int num1 = minus.poll();
            int num2 = minus.poll();

            res += num1 * num2;
        }

        System.out.println(res);

    }
}
