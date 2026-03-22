package 백준.implementation.Silver.BOJ_1244_스위치켜고끄기;

import java.io.*;
import java.util.*;

public class 스위치켜고끄기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 스위치 개수
        int N = Integer.parseInt(br.readLine());

        // 스위치 on/off 정보
        int[] sw = new int[N];

        // 스위치 정보 저장
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {

            sw[i] = Integer.parseInt(st.nextToken());
        }

        // 학생 수
        int student = Integer.parseInt(br.readLine());

        for(int testCase = 0; testCase < student; testCase++) {
            st = new StringTokenizer(br.readLine());

            // 학생 성별 저장
            int gender = Integer.parseInt(st.nextToken());

            // 지정된 스위치 번호 저장
            int switchNum = Integer.parseInt(st.nextToken());

            // 남학생 일 경우
            if(gender == 1) {

                // switchNum 에서 시작, switchNum 의 배수 개수만큼 반복
                for(int i = switchNum - 1; i < N; i += switchNum) {

                    // Swap
                    sw[i] = 1 - sw[i];
                }
            } else { // 여학생 일 경우

                // 대칭되는 지점 switchNum - 1
                int center = switchNum - 1;

                // 대칭되는 지점 우선적 swap
                sw[center] = 1 - sw[center];

                // 대칭 인덱스
                int k = 1;

                while(true) {

                    // 대칭 지점에 대한 인덱스가 배열의 전체 인덱스를 넘어갈 경우
                    if(center - k < 0 || center + k >= N) break;

                    // 대칭이 아닐 경우
                    if(sw[center - k] != sw[center + k]) break;

                    sw[center - k] = 1 - sw[center - k];
                    sw[center + k] = 1 - sw[center + k];

                    // 다음 대칭 지점으로 이동
                    k++;
                }

            }
        }

        for(int i = 0; i < N; i++) {

            // 20, 40, 60 ... 줄 마다 줄 바꿈
            System.out.print(sw[i] + " ");

            if((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}