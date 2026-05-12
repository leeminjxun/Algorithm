package Swea.Implementation.D4.Swea_4408_자기방으로돌아가기;

import java.io.*;
import java.util.*;

public class 자기방으로돌아가기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[] room = new int[401];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int currentRoom = Integer.parseInt(st.nextToken());
                int backRoom = Integer.parseInt(st.nextToken());

                int start = Math.min(currentRoom, backRoom);
                int end = Math.max(currentRoom, backRoom);

                start += (start % 2 == 0) ? -1 : 0;
                end += (end % 2 != 0) ? 1 : 0;

                for(int check = start; check <= end; check++) {
                    room[check] += 1;
                }
             }

            Arrays.sort(room);

            sb.append("#").append(testCase).append(" ").append(room[400]).append("\n");
        }

        System.out.print(sb);
    }
}
