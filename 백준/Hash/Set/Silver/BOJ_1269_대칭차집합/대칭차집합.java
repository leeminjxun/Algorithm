package 백준.Hash.Set.Silver.BOJ_1269_대칭차집합;

import java.io.*;
import java.util.*;

public class 대칭차집합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        HashSet<Integer> aSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        HashSet<Integer> bSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < b; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        for(int A : aSet) {
            if(!bSet.contains(A)) {
                cnt++;
            }
        }

        for(int B : bSet) {
            if(!aSet.contains(B)) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
