package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//압축
public class compression {
    public int[] solution(String msg) {

        HashMap<String, Integer> map =new HashMap<>();

        for (int i = 0; i < 26; i++) {
            int alphabet = i+65;
            char c = (char)alphabet;
            map.put(Character.toString(c), i+1);
        }
        int next = 26;

        List<Integer> res = new ArrayList<>();
        int idx = 0;
        int jump = 1;

        while (idx < msg.length()) {
            for (int i = idx + jump; i > idx; i--) {
                if (i <= msg.length() && map.containsKey(msg.substring(idx, i))) {
                    res.add(map.get(msg.substring(idx, i)));

                    if (i < msg.length()) {
                        next++;
                        map.put(msg.substring(idx,i+1), next);
                    }
                    if (i == idx + jump) {
                        jump++;
                    }
                    idx = i;
                    break;
                }
            }
        }

        int[] answer = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }
}
