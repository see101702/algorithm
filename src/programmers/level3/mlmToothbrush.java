package programmers.level3;

import java.util.*;

// 다단계 칫솔 판매
public class mlmToothbrush {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        Map<String, String> prev = new HashMap<>();
        Map<String, Integer> res = new HashMap<>();

        for (int i = 0; i < n; i++) {
            prev.put(enroll[i], referral[i]);
        }

        int m = seller.length;

        for (int i = 0; i < m; i++) {
            String sell = seller[i];
            int cost = amount[i] * 100;

            while (!sell.equals("-")) {
                if ((int)(cost * 0.1) < 1) {
                    res.put(sell, res.getOrDefault(sell, 0) + cost);
                    break;
                } else {
                    res.put(sell, res.getOrDefault(sell, 0) + (cost - (int)(cost * 0.1)));
                    cost = (int)(cost * 0.1);
                    sell = prev.get(sell);
                }
            }
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (res.containsKey(enroll[i])) {
                int temp = res.get(enroll[i]);
                result[i] = temp;
            } else {
                result[i] = 0;
            }
        }

        return result;
    }
}
