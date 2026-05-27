package programmers.Hash.Lv1.포켓몬;

import java.util.*;

public class 포켓몬 {
    public int solution(int[] nums) {
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();

        for(int n : nums) {
            if(!set.contains(n)) set.add(n);

            if(set.size() == nums.length / 2) break;
        }

        return set.size();
    }
}
