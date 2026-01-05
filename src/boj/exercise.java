package boj;

import java.io.*;
import java.util.*;

// 1956
public class exercise {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] dp = new int[v+1][v+1];

        for (int i = 1; i <= v; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dp[a][b] = c;
        }

        for (int k = 1; k <= v; k++) {
            dp[k][k] = 0;
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE) {
                        if (i == j && dp[i][j] == 0) {
                            dp[i][j] = dp[i][k] + dp[k][j];
                            continue;
                        }
                        if (dp[i][j] > dp[i][k] + dp[k][j]) {
                            dp[i][j] = dp[i][k] + dp[k][j];
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            if (dp[i][i] != 0) {
                min = Math.min(min, dp[i][i]);
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}