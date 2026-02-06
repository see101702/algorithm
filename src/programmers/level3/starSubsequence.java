package programmers.level3;

import java.util.*;

// 스타 수열
public class starSubsequence {
    public int solution(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        int answer = 0;
        for (int key : map.keySet()) {
            int cnt = map.get(key);
            int pair = 0;

            if (cnt * 2 < answer) continue;

            for (int i = 0; i < a.length - 1; i++) {
                if ((a[i] == key || a[i+1] == key) && a[i] != a[i+1]) {
                    pair++;
                    i++;
                }
            }

            answer = Math.max(answer, pair*2);
        }

        return answer;
    }
}
