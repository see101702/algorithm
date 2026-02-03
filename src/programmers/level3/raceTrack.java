package programmers.level3;

import java.util.*;

// 경주로 건설
public class raceTrack {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public int solution(int[][] board) {
        int n = board.length;
        int[][][] visited = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) Arrays.fill(visited[i][j], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[3]));
        pq.add(new int[] {0,0,-1,0});
        int ans = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0];
            int y = now[1];
            int d = now[2];
            int w = now[3];

            if (x == n-1 && y == n-1) {
                ans = visited[x][y][d];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;
                if (board[newX][newY] == 1) continue;
                if (d == -1) {
                    visited[newX][newY][i] = 100;
                    pq.add(new int[] {newX, newY, i, visited[newX][newY][i]});
                } else {
                    int temp = 0;
                    if (d == i) temp = visited[x][y][d] + 100;
                    else temp = visited[x][y][d] + 600;

                    if (visited[newX][newY][i] > temp) {
                        visited[newX][newY][i] = temp;
                        pq.add(new int[] {newX, newY, i, visited[newX][newY][i]});
                    }
                }
            }
        }

        return ans;
    }
}
