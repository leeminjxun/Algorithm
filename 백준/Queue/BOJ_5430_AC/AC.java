package 백준.Queue.BOJ_5430_AC;

import java.io.*;
import java.util.*;

public class AC {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 0; testCase < T; testCase++) {
            Deque<Integer> deque = new ArrayDeque<>();

            String op = br.readLine();

            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            for(int i = 0; i < N; i++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean isError = false;
            boolean isReverse = false;
            for(int i = 0; i < op.length(); i++) {
                char ch = op.charAt(i);

                if(ch == 'R') {
                    isReverse = !isReverse;

                } else {
                    if(!deque.isEmpty()) {
                        if(isReverse) {
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                    } else {
                        isError = true;
                        break;
                    }
                }
            }


            if(isError) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");

                if(!deque.isEmpty()) {
                    Iterator<Integer> iter = isReverse ? deque.descendingIterator() : deque.iterator();

                    sb.append(iter.next());
                    while(iter.hasNext()) {
                        sb.append(",").append(iter.next());
                    }
                }

                sb.append("]\n");
            }

        }

        System.out.println(sb);
    }
}
