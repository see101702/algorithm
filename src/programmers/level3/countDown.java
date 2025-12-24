package programmers.level3;

import java.util.*;

public class countDown {
    public int[] solution(int target) {
        int[][] dp = new int[target+1][2];
        for (int i = 1; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[0][0] = 0;
        dp[0][1] = 0;

        List<int[]> sc = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            sc.add(new int[] {i, 1});
            sc.add(new int[] {i*2, 0});
            sc.add(new int[] {i*3, 0});
            sc.add(new int[] {50, 1});
        }

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < sc.size(); j++) {
                int score = sc.get(j)[0];
                int sb = sc.get(j)[1];

                if (score > i) continue;

                if (dp[i][0] > dp[i-score][0] + 1
                        || (dp[i][0] == dp[i-score][0] + 1 && dp[i][1] < dp[i-score][1] + sb)) {
                    dp[i][0] = dp[i-score][0] + 1;
                    dp[i][1] = dp[i-score][1] + sb;
                }
            }
        }

        return dp[target];
    }
}
