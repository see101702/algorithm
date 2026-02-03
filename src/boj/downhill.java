package boj;

import java.util.*;
import java.io.*;

// 1520
public class downhill {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr;
    static int[][] dp;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0,0));
    }
    public static int dfs(int x, int y) {
        if (x == n-1 && y == m-1) return 1;
        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
            if (arr[x][y] > arr[newX][newY]) {
                dp[x][y] += dfs(newX, newY);
            }
        }

        return dp[x][y];
    }
}
