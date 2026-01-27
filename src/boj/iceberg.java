package boj;

import java.io.*;
import java.util.*;

// 2573
public class iceberg {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr;
    static int n, m, cnt;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        cnt = 0;
        int year = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        out:while (true) {
            year++;
            arr = melt();
            visited = new boolean[n][m];
            cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] != 0 && !visited[i][j]) {
                        bfs(i, j);
                    }
                    if (cnt > 1) break out;
                }
            }

            if (cnt == 0) {
                year = 0;
                break;
            }
        }
        System.out.println(year);
    }
    public static int[][] melt() {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i].clone();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int newX = i + dx[k];
                        int newY = j + dy[k];
                        if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
                        if (arr[newX][newY] == 0) count++;
                    }
                    temp[i][j] -= count;
                    if (temp[i][j] < 0) temp[i][j] = 0;
                }
            }
        }
        return temp;
    }
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = now[0] + dx[i];
                int newY = now[1] + dy[i];

                if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;

                if (!visited[newX][newY] && arr[newX][newY] != 0) {
                    q.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }

        cnt++;
    }
}
