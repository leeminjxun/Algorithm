package 백준;
import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split("-");

        int result = 0;

        for(int i = 0; i < tokens.length; i++) {
            int sum = 0;

            for(String num : tokens[i].split("\\+")) {
                sum += Integer.parseInt(num);
            }

            if(i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);

    }
}
