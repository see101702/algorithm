package boj;

import java.io.*;
import java.util.*;

// 11562
public class baekyangroBreak {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (b == 0) {
                dp[u][v] = 0;
                dp[v][u] = 1;
            }
            if (b == 1) {
                dp[u][v] = 0;
                dp[v][u] = 0;
            }
        }

        for (int k = 1; k <= n; k++) {
            dp[k][k] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }
        }

        int k = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(dp[s][e]);
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
