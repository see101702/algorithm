package programmers.level3;

import java.util.*;

// 보석쇼핑
public class jewelShopping {
    public int[] solution(String[] gems) {
        String[] arr = Arrays.stream(gems).distinct().toArray(String[]::new);
        int n = arr.length;

        int left = 0;
        int right = 0;
        int bestleft = 0;
        int bestright = 0;

        int bestlen = Integer.MAX_VALUE;
        HashMap<String, Integer> map = new HashMap<>();

        while (true) {
            if (map.size() == n) {
                if (bestlen > right - left) {
                    bestleft = left;
                    bestright = right;
                    bestlen = right - left;
                }

                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            } else {
                if (right == gems.length) break;
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }
        }

        int[] result = new int[2];
        result[0] = bestleft+1;
        result[1] = bestright;

        return result;
    }
}
