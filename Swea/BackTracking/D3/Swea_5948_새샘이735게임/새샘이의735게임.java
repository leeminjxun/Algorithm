package Swea.BackTracking.D3.Swea_5948_새샘이735게임;

import java.io.*;
import java.util.*;

public class 새샘이의735게임 {
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");
            arr = new int[7];
            visited = new boolean[7];
            list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            Collections.sort(list);

            sb.append(list.get(list.size() - 5)).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int depth, int sum) {

        if(depth == 3) {
            if(list.contains(sum)) return;

            list.add(sum);
            return;
        }

        for(int i = 0; i < 7; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, sum + arr[i]);
                visited[i] = false;
            }
        }

        dfs(depth + 1, sum);

    }
}
