package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class distance {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int[] solution(String[][] places) {
        int[] result = new int[5];
        for (int i = 0; i < 5; i++) {
            boolean[][] visited = new boolean[5][5];
            String[] strs = places[i];
            boolean flag = true;

            outer:for (int s = 0; s < 5; s++) {
                for (int t = 0; t < 5; t++) {
                    if (!visited[s][t] && strs[s].charAt(t) == 'P') {
                        if (!bfs(s,t, visited, strs)) {
                            flag = false;
                            break outer;
                        }
                    }
                }
            }

            if (flag) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }

        return result;
    }

    public boolean bfs(int s, int t, boolean[][] visited, String[] strs) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {s, t});
        visited[s][t] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = now[0] + dx[i];
                int newY = now[1] + dy[i];

                if (newX < 0 || newX >= 5 || newY < 0 || newY >= 5) continue;

                if (Math.abs(s-newX) + Math.abs(t-newY) <= 2 && !visited[newX][newY]) {
                    if (strs[newX].charAt(newY) == 'P') {
                        return false;
                    }
                    if (strs[newX].charAt(newY) == 'O') {
                        q.add(new int[] {newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        return true;
    }
}
