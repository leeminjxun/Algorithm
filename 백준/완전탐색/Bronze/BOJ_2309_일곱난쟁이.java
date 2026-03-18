package 백준.완전탐색.Bronze;

import java.io.*;
import java.util.*;

public class BOJ_2309_일곱난쟁이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int[] result = new int[7];

        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                int sum = 0;
                int index = 0;
                for(int k = 0; k < 9; k++) {
                    if(k == i || k == j) continue;
                    sum += arr[k];
                    result[index++] = arr[k];
                }
                if(sum == 100) {
                    Arrays.sort(result);
                    for(int z = 0; z < 7; z++) {
                        System.out.println(result[z]);
                    }
                    return ;
                }
            }
        }

    }
}
