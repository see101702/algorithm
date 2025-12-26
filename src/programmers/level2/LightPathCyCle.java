package programmers.level2;

import java.util.*;

// 빛의 경로 사이클
public class LightPathCyCle {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][][] visited;
    public int[] solution(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        visited = new boolean[n][m][4];
        List<Integer> li = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int t = 0; t < 4; t++) {
                    if (!visited[i][j][t]) {
                        int ans = travel(grid,i,j,t);
                        if (ans > 0) {
                            li.add(ans);
                        }
                    }
                }
            }
        }

        int[] arr = new int[li.size()];
        Collections.sort(li);
        for (int i = 0; i < li.size(); i++) {
            arr[i] = li.get(i);
        }

        return arr;
    }

    public static int travel(String[] grid, int x, int y, int d) {
        int n = grid.length;
        int m = grid[0].length();
        int cnt = 0;

        while (!visited[x][y][d]) {
            visited[x][y][d] = true;
            cnt++;

            if (grid[x].charAt(y) == 'L') {
                if (d == 3) {
                    d = 0;
                } else {
                    d = d + 1;
                }
            }
            if (grid[x].charAt(y) == 'R') {
                if (d == 0) {
                    d = 3;
                } else {
                    d = d-1;
                }
            }
            x = (x + dx[d] + n) % n;
            y = (y + dy[d] + m) % m;
        }

        return cnt;
    }
}
