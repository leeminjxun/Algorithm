package 백준.Sort.Silver.BOJ_10814_나이순정렬;

import java.io.*;
import java.util.*;

public class 나이순정렬 {
    // 풀이 1. Member 클래스 생성을 통해 List 로 정렬
    // 실행속도 매우 느림
//    static class Member {
//        int age;
//        String name;
//        int seq;
//
//        public Member(int age, String name, int seq) {
//            this.age = age;
//            this.name = name;
//            this.seq = seq;
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int N = Integer.parseInt(br.readLine());
//
//        List<Member> list = new ArrayList<>();
//
//        for(int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            int age = Integer.parseInt(st.nextToken());
//            String name = st.nextToken();
//            int seq = i;
//
//            list.add(new Member(age, name, seq));
//
//        }
//
//        Collections.sort(list, (a, b) -> {
//            int ageCompare = a.age - b.age;
//            if(ageCompare != 0) return ageCompare;
//
//            return a.seq - b.seq;
//
//        });
//
//        for(Member m : list) {
//            System.out.print(m.age + " ");
//            System.out.println(m.name);
//        }
//    }

    // 풀이 2 . index 를 age 로 매칭시킨 배열을 통한 정렬 출력
    // 빠른 실행속도 장점
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder[] sb = new StringBuilder[200];
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());

            if(sb[age- 1] == null) {
                sb[age - 1] = new StringBuilder();
            }
            sb[age - 1].append(age).append(" ").append(st.nextToken()).append("\n");
        }

        int done = 0;

        for(int i = 0; i < sb.length; i++) {
            if(sb[i] != null) {
                done++;
                System.out.print(sb[i]);
            }
            if(done == N) {
                break;
            }
        }
    }
}
