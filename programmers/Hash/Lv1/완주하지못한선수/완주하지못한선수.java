package programmers.Hash.Lv1.완주하지못한선수;

import java.util.*;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String ans = "";

        HashMap<String, Integer> hm = new HashMap<>();

        for(String p : participant) hm.put(p, hm.getOrDefault(p, 0) + 1);
        for(String c : completion) hm.put(c, hm.get(c) - 1);

        for(String key : hm.keySet()) {
            if(hm.get(key) != 0) ans = key;
        }

        return ans;
    }
}
