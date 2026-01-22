package boj;

import java.io.*;
import java.util.*;

// 14500
public class tetromino {
    static int[][] arr;
    static int n, m;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;

                checkT(i,j);
            }
        }

        System.out.println(max);
    }

    public static void dfs(int x, int y, int sum, int cnt) {
        if (cnt > 4) return;
        if (cnt == 4) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;

            if (!visited[newX][newY]) {
                visited[newX][newY] = true;
                dfs(newX, newY, sum + arr[newX][newY], cnt+1);
                visited[newX][newY] = false;
            }
        }
    }

    public static void checkT(int x, int y) {
        int sum = arr[x][y];
        for (int i = 0; i < 4; i++) {
            sum = arr[x][y];
            boolean flag = true;
            for (int j = 0; j < 4; j++) {
                if (i == j) continue;

                int newX = x + dx[j];
                int newY = y + dy[j];

                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    flag = false;
                    break;
                }
                sum += arr[newX][newY];
            }
            if (flag) max = Math.max(max, sum);
        }
    }
}
