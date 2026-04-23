package Swea.Implementation.D3.Swea_4047_영준이의카드카운팅;

import java.io.*;
import java.util.*;

public class 영준이의카드카운팅 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            String s = br.readLine();

            HashSet<Integer> S = new HashSet<>();
            HashSet<Integer> D = new HashSet<>();
            HashSet<Integer> H = new HashSet<>();
            HashSet<Integer> C = new HashSet<>();

            boolean isError = false;

            for(int i = 0; i < s.length(); i += 3) {
                char ch = s.charAt(i);

                int num = Integer.parseInt(s.substring(i + 1, i + 3));

                if(ch == 'S') {
                    if(S.contains(num)) {
                        isError = true;
                        break;
                    }

                    S.add(num);
                }

                if(ch == 'D') {
                    if(D.contains(num)) {
                        isError = true;
                        break;
                    }

                    D.add(num);
                }

                if(ch == 'H') {
                    if(H.contains(num)) {
                        isError = true;
                        break;
                    }

                    H.add(num);
                }

                if(ch == 'C') {
                    if(C.contains(num)) {
                        isError = true;
                        break;
                    }

                    C.add(num);
                }
            }

            sb.append("#").append(testCase).append(" ");

            if(isError) sb.append("ERROR");
            else {
                sb.append(13 - S.size()).append(" ")
                        .append(13 - D.size()).append(" ")
                        .append(13 - H.size()).append(" ")
                        .append(13 - C.size());
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
