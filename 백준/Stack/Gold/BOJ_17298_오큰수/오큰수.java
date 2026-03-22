package 백준.Stack.Gold.BOJ_17298_오큰수;

import java.io.*;
import java.util.*;

public class 오큰수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(result, -1);

        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
