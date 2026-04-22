package Swea.Implementation.D3.Swea_14361_숫자가같은배수;

import java.io.*;
import java.util.*;

public class 숫자가같은배수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            String N = br.readLine();

            int[] arr = new int[10];

            for(int i = 0; i < N.length(); i++) {
                arr[N.charAt(i) - '0']++;
            }

            String multiN = N;

            int num = Integer.parseInt(multiN) + Integer.parseInt(N);

            multiN = String.valueOf(num);

            boolean isPossible = false;

            while(N.length() == multiN.length()) {
                int[] copyArr = arr.clone();

                for(int i = 0; i < multiN.length(); i++) {
                    if(copyArr[multiN.charAt(i) - '0'] == 0) {
                        break;
                    }

                    copyArr[multiN.charAt(i) - '0']--;
                }

                Arrays.sort(copyArr);

                if(copyArr[9] == 0) {
                    isPossible = true;
                    break;
                }

                num = Integer.parseInt(multiN) + Integer.parseInt(N);

                multiN = String.valueOf(num);
            }

            sb.append("#").append(testCase).append(" ").append(isPossible ? "possible" : "impossible").append("\n");

        }

        System.out.println(sb);
    }
}
