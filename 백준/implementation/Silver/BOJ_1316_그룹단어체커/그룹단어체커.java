package 백준.implementation.Silver.BOJ_1316_그룹단어체커;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 그룹단어체커 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int cnt = 0;

        for(int testCase = 0; testCase < T; testCase++) {

            boolean isGroup = true;

            String word = br.readLine();

            boolean[] arr = new boolean[26];

            for(int i = 0; i < word.length() - 1; i++) {
                if(word.charAt(i) != word.charAt(i + 1)) {
                    int prevIndex = word.charAt(i) - 'a';
                    int index = word.charAt(i + 1) - 'a';

                    arr[prevIndex] = true;

                    if(arr[index]) {
                        isGroup = false;

                        break;
                    }
                }
            }

            if(isGroup) cnt++;
        }

        System.out.println(cnt);
    }
}
