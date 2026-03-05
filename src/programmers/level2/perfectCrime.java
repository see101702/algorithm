package programmers.level2;

import java.util.*;
// 완전범죄
public class perfectCrime {
    public int solution(int[][] info, int n, int m) {
        int num = info.length;
        int[][] dp = new int[num+1][m];
        for (int i = 0; i <= num; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int i = 1; i <= num; i++) {
            int a = info[i-1][0];
            int b = info[i-1][1];

            for (int j = 0; j < m; j++) {
                if (dp[i-1][j] == Integer.MAX_VALUE) continue;
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                if (j+b < m) {
                    dp[i][j+b] = Math.min(dp[i][j+b], dp[i-1][j]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            ans = Math.min(ans, dp[num][i]);
        }

        if (ans >= n) return -1;
        else return ans;
    }
}