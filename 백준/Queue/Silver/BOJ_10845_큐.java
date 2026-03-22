package 백준.Queue.Silver;

import java.io.*;
import java.util.*;

public class BOJ_10845_큐 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        LinkedList<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        int lastAdd = 0;

        for(int testCase = 0; testCase < N; testCase++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch(command) {
                case "push" :
                    lastAdd = Integer.parseInt(st.nextToken());
                    queue.add(lastAdd);
                    break;

                case "pop" :
                    System.out.println(queue.isEmpty() ? -1 : queue.poll());
                    break;

                case "size" :
                    System.out.println(queue.size());
                    break;

                case "empty" :
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;

                case "front" :
                    System.out.println(queue.isEmpty() ? -1 : queue.peek());
                    break;

                case "back" :
                    System.out.println(queue.isEmpty() ? -1 : lastAdd);
                    break;
            }
        }
    }
}
