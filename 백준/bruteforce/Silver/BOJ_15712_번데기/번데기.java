package 백준.bruteforce.Silver.BOJ_15712_번데기;

import java.io.*;
import java.util.*;

public class 번데기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int type = Integer.parseInt(br.readLine());

        int cnt = 0;

        int bbun = 0;
        int degi = 0;
        int stage = 2;

        while(true) {
            String[] base = {"b", "d", "b", "d"};

            for(String s : base) {
                if(s.equals("b")) {
                    bbun++;

                    if(type == 0 && T == bbun) {
                        System.out.println(cnt % A);
                        return;
                    }
                } else {
                    degi++;

                    if(type == 1 && T == degi) {
                        System.out.println(cnt % A);
                        return;
                    }
                }

                cnt++;
            }

            for(int i = 0; i < stage; i++) {
                bbun++;

                if(type == 0 && T == bbun) {
                    System.out.println(cnt % A);
                    return ;
                }

                cnt++;
            }

            for(int i = 0; i < stage; i++) {
                degi++;

                if(type == 1 && T == degi) {
                    System.out.println(cnt % A);
                    return ;
                }

                cnt++;
            }

            stage++;
        }
    }
}
