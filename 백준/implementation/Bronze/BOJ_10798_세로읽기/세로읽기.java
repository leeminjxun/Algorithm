package 백준.implementation.Bronze.BOJ_10798_세로읽기;

import java.io.*;

public class 세로읽기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[5][15];

        for(int i = 0; i < 5; i++) {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                if(arr[j][i] != '\0'){
                    System.out.print(arr[j][i]);
                }
            }
        }

    }
}
