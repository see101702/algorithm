package programmers.level3;

import java.util.*;

// 양과 늑대
public class sheepAndWolf {
    static List<Integer>[] li;
    static int max;
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        li = new ArrayList[n];
        max = 0;

        for (int i = 0; i < n; i++) {
            li[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];

            li[e[0]].add(e[1]);
        }

        List<Integer> next = new ArrayList<>();
        next.add(0);

        dfs(0, 0, 0, info, next);

        return max;
    }
    public static void dfs(int node, int s, int w, int[] info, List<Integer> next) {
        if (info[node] == 0) {
            s += 1;
        } else {
            w += 1;
        }

        if (s <= w) return;

        max = Math.max(max, s);

        List<Integer> nowLi = new ArrayList<>(next);

        nowLi.remove(Integer.valueOf(node));

        List<Integer> child = li[node];
        for (int i = 0; i < child.size(); i++) {
            nowLi.add(child.get(i));
        }

        for (int i = 0; i < nowLi.size(); i++) {
            dfs(nowLi.get(i), s, w, info, nowLi);
        }
    }
}
