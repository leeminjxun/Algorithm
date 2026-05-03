package Swea.Bruteforce.D3.Swea_6190_정곤이의단조증가하는수;
import java.io.*;
import java.util.*;

public class 정곤이의단조증가하는수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[] A = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;

            boolean isExisted = false;

            Arrays.sort(A);

            // 최댓값을 구해야하기 때문에 내림차순으로 계산
            for(int i = N - 1; i > 0; i--) {
                for(int j = i - 1; j >= 0; j--) {
                    int num = A[i] * A[j];

                    if(num < max) break;

                    String sNum = String.valueOf(num);

                    boolean isUp = true;

                    for(int k = 0; k < sNum.length() - 1; k++) {
                        int d1 = Integer.parseInt(String.valueOf(sNum.charAt(k)));
                        int d2 = Integer.parseInt(String.valueOf(sNum.charAt(k + 1)));

                        if(d1 > d2) {
                            isUp = false;
                            break;
                        }
                    }

                    if(isUp) {
                        isExisted = true;
                        max = Math.max(max, num);
                    }
                }
            }

            sb.append("#").append(testCase).append(" ").append(isExisted ? max : -1).append("\n");

        }

        System.out.println(sb);
    }
}
