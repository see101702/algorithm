package programmers.level2;

import java.util.*;

// 후보키
public class candidateKey {
    static List<String> candi = new ArrayList<>();
    public int solution(String[][] relation) {
        for (int i = 0; i < relation[0].length; i++) {
            boolean[] visited = new boolean[relation[0].length];
            dfs(visited, 0, i+1, 0, relation);
        }

        return candi.size();
    }

    public static void dfs(boolean[] visited, int start, int end, int depth, String[][] relation) {
        if (end == depth) {
            List<Integer> li = new ArrayList<>();
            String key = "";

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    li.add(i);
                    key += String.valueOf(i);
                }
            }

            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < relation.length; i++) {
                String str = "";
                for (int j : li) {
                    str = str + relation[i][j] + "|";
                }

                if (map.containsKey(str)) {
                    return;
                } else {
                    map.put(str, 0);
                }
            }

            for (String can: candi) {
                int cnt = 0;
                for (int i = 0; i < key.length(); i++) {
                    if (can.contains(String.valueOf(key.charAt(i)))) {
                        cnt++;
                    }
                }
                if (cnt == can.length()) return;
            }

            candi.add(key);
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(visited, i, end, depth+1, relation);
            visited[i] = false;
        }
    }
}
