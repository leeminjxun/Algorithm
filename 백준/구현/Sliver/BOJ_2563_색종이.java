package 백준.구현.Sliver;

import java.io.*;
import java.util.*;

public class BOJ_2563_색종이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[][] paper = new boolean[100][100];

        int N = Integer.parseInt(br.readLine());

        for(int testCase = 0; testCase < N; testCase++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            for(int i = x; i < x + 10; i++) {
                for(int j = y; j < y + 10; j++) {
                    if(!paper[i][j]) paper[i][j] = true;
                }
            }
        }

        int size = 0;

        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(paper[i][j]) size++;
            }
        }

        System.out.println(size);

    }
}
