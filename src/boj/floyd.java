package boj;

import java.io.*;
import java.util.*;

public class floyd {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dp[a][b] = w;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][i] = 0;
            for (int s = 1; s <= n; s++) {
                for (int f = 1; f <= n; f++) {
                    if (dp[s][i] != Integer.MAX_VALUE && dp[i][f] != Integer.MAX_VALUE) {
                        dp[s][f] = Math.min(dp[s][f], dp[s][i] + dp[i][f]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }
}
