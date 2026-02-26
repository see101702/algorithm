package programmers.level2;

import java.util.*;

// 게임 맵 최단거리
public class shortestPathGame {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] visited = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});
        visited[0][0] = 1;
        int ans = -1;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == n-1 && now[1] == m-1) {
                ans = visited[now[0]][now[1]];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = now[0] + dx[i];
                int newY = now[1] + dy[i];

                if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
                if (visited[newX][newY] == 0 && maps[newX][newY] == 1) {
                    q.add(new int[] {newX, newY});
                    visited[newX][newY] = visited[now[0]][now[1]] + 1;
                }
            }
        }

        return ans;
    }
}
