package 백준.Greedy.Gold.BOJ_1931_회의실배정;

import java.io.*;
import java.util.*;

public class 회의실배정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] meetings = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings[i][0] = start;
            meetings[i][1] = end;
        }

        Arrays.sort(meetings, (a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];

            return a[1] - b[1];
        });


        int endTime = 0;
        int meetingCnt = 0;

        for(int i = 0; i < N; i++) {
            if(meetings[i][0] >= endTime) {
                endTime = meetings[i][1];
                meetingCnt++;
            }
        }

        System.out.println(meetingCnt);
    }
}
