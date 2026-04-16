package 백준.bruteforce.Silver.BOJ_2422_한윤정이이탈리아에가서아이스크림을사먹는데;

import java.io.*;
import java.util.*;

public class 한윤정이이탈리아에가서아이스크림을사먹는데 {
    static int N, M;

    static boolean[][] badComb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        badComb = new boolean[N + 1][N + 1];

        int ans = 0;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            badComb[a][b] = true;

            // 반대의 경우도 고려
            badComb[b][a] = true;
        }

        for(int i = 1; i <= N - 2; i++) {
            for(int j = i + 1; j <= N - 1; j++) {
                if(badComb[i][j]) continue;

                for(int k = j + 1; k <= N; k++) {
                    if(badComb[i][k] || badComb[j][k]) continue;

                    ans++;
                }
            }
        }

        System.out.println(ans);

    }
}

// 메모리 초과 코드

/**

static int N, M;

static int[][] badComb;

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    badComb = new int[M][2];

    int ans = 0;

    for(int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());

        badComb[i][0] = Integer.parseInt(st.nextToken());
        badComb[i][1] = Integer.parseInt(st.nextToken());
    }

    for(int i = 1; i <= N - 2; i++) {
        for(int j = i + 1; j <= N - 1; j++) {
            for(int k = j + 1; k <= N; k++) {
                String ice = "" + i + j + k;

                if(!valid(ice)) continue;

                ans++;
            }
        }
    }

    System.out.println(ans);

}

static boolean valid(String ice) {
    for(int i = 0; i < M; i++) {
        String comb1 = String.valueOf(badComb[i][0]);
        String comb2 = String.valueOf(badComb[i][1]);

        if(ice.contains(comb1) && ice.contains(comb2)) return false;
    }

    return true;
}*/
