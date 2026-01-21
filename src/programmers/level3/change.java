package programmers.level3;

// 거스름돈
public class change {
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];

        for (int i = 0; i < money.length; i++) {
            int now = money[i];

            for (int j = now; j <= n; j++) {
                if (now == j) {
                    dp[now] += 1;
                } else {
                    if (dp[j-now] > 0) {
                        dp[j] += dp[j-now];
                    }
                }
            }
        }

        return dp[n];
    }
}
