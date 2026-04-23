package Swea.Implementation.D3.Swea_10761_신뢰;

import java.io.*;
import java.util.*;

public class 신뢰 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int loc_O  = 1; int time_O = 0;
            int loc_B = 1; int time_B = 0;

            int totalTime = 0;

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            for(int i = 0; i < N; i++) {
                String robot = st.nextToken();
                int location = Integer.parseInt(st.nextToken());

                if(robot.equals("B")) {
                    int move = Math.abs(location - loc_B);

                    time_B = Math.max(totalTime, time_B + move) + 1;
                    totalTime = time_B;
                    loc_B = location;
                } else {
                    int move = Math.abs(location - loc_O);

                    time_O = Math.max(totalTime, time_O + move) + 1;
                    totalTime = time_O;
                    loc_O = location;
                }
            }

            sb.append("#").append(testCase).append(" ").append(totalTime).append("\n");
        }

        System.out.println(sb);
    }
}
