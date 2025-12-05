package programmers.level2;

import java.util.*;

// 메뉴리뉴얼
public class menuRenewal {
    static HashMap<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {

        List<String> li = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = String.valueOf(chars);
        }

        for (int i = 0; i < course.length; i++) {
            int cnt = course[i];
            map = new HashMap<>();
            int max = 0;

            for (int j = 0; j < orders.length; j++) {
                comb("", orders[j], cnt);
            }

            for (String key : map.keySet()) {
                max = Math.max(max, map.get(key));
            }

            for (String key: map.keySet()) {
                if (map.get(key) >= 2 && map.get(key) == max) {
                    li.add(key);
                }
            }
        }

        Collections.sort(li);


        String[] result = li.toArray(new String[li.size()]);

        return result;
    }

    public static void comb(String str, String order, int cnt) {
        if (cnt == 0) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }

        for (int i = 0; i < order.length(); i++) {
            comb(str + order.charAt(i), order.substring(i+1), cnt -1);
        }
    }
}
