package 백준.Greedy.Silver.BOJ_1541_잃어버린괄호;

import java.io.*;
import java.util.*;

public class 잃어버린괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] minusGroup = br.readLine().split("-");

        int totalSum = 0;

        for(int i = 0; i < minusGroup.length; i++) {
            int currentSum = calculator(minusGroup[i]);

            if(i == 0) {
                totalSum += currentSum;
            } else {
                totalSum -= currentSum;
            }
        }

        System.out.println(totalSum);
    }

    static int calculator(String plusGroup) {
        int sum = 0;

        String[] plus = plusGroup.split("\\+");

        for(int i = 0; i < plus.length; i++) {
            sum += Integer.parseInt(plus[i]);
        }

        return sum;

    }
}
