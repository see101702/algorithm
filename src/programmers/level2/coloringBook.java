package programmers.level2;

import java.util.*;

// 카카오프렌즈 컬러링북
public class coloringBook {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static int max;
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        List<Integer> li = new ArrayList<>();
        max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    li.add(bfs(i, j, picture, m, n));
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = li.size();
        answer[1] = max;

        return answer;
    }
    public static int bfs(int x, int y, int[][] picture, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = now[0] + dx[i];
                int newY = now[1] + dy[i];

                if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                if (picture[newX][newY] == 0) continue;

                if (!visited[newX][newY] && picture[newX][newY] == picture[x][y]) {
                    q.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                    cnt++;
                }
            }
        }
        max = Math.max(max, cnt);
        return cnt;
    }
}
