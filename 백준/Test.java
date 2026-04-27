package 백준;
import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] dna = new String[N];

        for(int i = 0; i < N; i++) {
            dna[i] = br.readLine();
        }

        int totalSum = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < K; i++) {
            int[] count = new int[4];

            for(int j = 0; j < N; j++) {
                char ch = dna[j].charAt(i);

                if(ch == 'A') count[0]++;
                if(ch == 'C') count[1]++;
                if(ch == 'T') count[2]++;
                if(ch == 'G') count[3]++;
            }

            int maxCount = 0;
            int maxIndex = 0;

            for(int k = 0; k < 4; k++) {
                if(maxCount < count[k]) {
                    maxCount = count[k];
                    maxIndex = k;
                }
            }

            totalSum += (N - maxCount);

            sb.append(getChar(maxIndex));
        }

        sb.append("\n");

        sb.append(totalSum);

        System.out.println(sb);
    }

    static char getChar(int idx) {
        if(idx == 0) return 'A';
        if(idx == 1) return 'C';
        if(idx == 2) return 'T';
        return 'G';
    }
}
