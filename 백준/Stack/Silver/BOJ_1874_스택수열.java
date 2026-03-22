package 백준.Stack.Silver;

import java.io.*;
import java.util.*;

public class BOJ_1874_스택수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        // 수열 저장 스택
        Stack<Integer> seq = new Stack<>();

        // 입출력 담당 스택
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N - 1; i >= 0; i--) {
            seq.push(arr[i]);
        }

        for(int i = 1; i < N + 1; i++) {
            stack.push(i);
            sb.append("+").append("\n");

            while(!stack.isEmpty() && !seq.isEmpty() && seq.peek().equals(stack.peek())) {
                seq.pop();
                stack.pop();
                sb.append("-").append("\n");
            }
        }

        if(!seq.isEmpty()) System.out.println("NO");
        else System.out.println(sb);
    }
}
