package programmers.level3;

import java.util.*;

// 합승택시요금
public class sharedTaxiFare {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < fares.length; i++) {
            int[] now = fares[i];
            dp[now[0]][now[1]] = now[2];
            dp[now[1]][now[0]] = now[2];
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

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, dp[s][i] + dp[i][a] + dp[i][b]);
        }

        return ans;
    }
}
