package Swea.Implementation.D3.Swea_1493_수의새로운연산;

import java.io.*;
import java.util.*;

public class 수의새로운연산 {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point numberToPoint(int n) {

        int d = 1;

        while(d * (d + 1) / 2 < n) {
            d++;
        }

        int start = d * (d - 1) / 2 + 1;
        int offset = n - start;

        int x = 1 + offset;
        int y = d - offset;

        return new Point(x, y);
    }

    static int pointToNumber(int x, int y) {
        int d = x + y - 1;
        return d * (d - 1) / 2 + x;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            Point P = numberToPoint(p);
            Point Q = numberToPoint(q);

            int x = P.x + Q.x;
            int y = P.y + Q.y;

            sb.append("#").append(testCase).append(" ").append(pointToNumber(x, y)).append("\n");
        }

        System.out.println(sb);

    }

    /**public static void main(String[] args) throws Exception {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st;

     int T = Integer.parseInt(br.readLine());

     StringBuilder sb = new StringBuilder();
     for(int testCase = 1; testCase <= T; testCase++) {
     sb.append("#").append(testCase).append(" ");

     st = new StringTokenizer(br.readLine());
     int p = Integer.parseInt(st.nextToken());
     int q = Integer.parseInt(st.nextToken());

     int[] p_Point = numToPoint(p);
     int[] q_Point = numToPoint(q);

     sb.append("(").append(p_Point[0]).append(p_Point[1]).append(")").append(" ");
     sb.append("(").append(q_Point[0]).append(q_Point[1]).append(")").append(" ");


     sb.append(pointToNum(p_Point[0] + q_Point[0], p_Point[1] + q_Point[1])).append("\n");

     }

     System.out.print(sb);
     }

     static int[] numToPoint(int num) {
     int start = 0;
     int end = 0;

     int line = 0;

     for(int i = 1; i <= num; i++) {
     start = end + 1;
     end += i;

     if(start <= num && num <= end) {
     line = i;
     break;
     }
     }

     int x = num - start + 1;
     int y = line - x + 1;

     return new int[] {x, y};
     }

     static int pointToNum(int x, int y) {
     int line = x + y - 1;

     int start = 1;

     for(int i = 1; i < line; i++) {
     start += i;
     }

     return start + x - 1;
     }
     * */
}
