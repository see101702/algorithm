package boj;

import java.io.*;
import java.util.*;

// 17404
public class RGBstreet2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] color = new int[n][3];
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            color[i][0] = Integer.parseInt(st.nextToken());
            color[i][1] = Integer.parseInt(st.nextToken());
            color[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int start = 0; start < 3; start++) {
            int[][] dp = new int[n][3];

            for (int i = 0; i < 3; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            dp[0][start] = color[0][start];

            for (int i = 1; i < n; i++) {
                if (dp[i-1][1] != Integer.MAX_VALUE || dp[i-1][2] != Integer.MAX_VALUE) {
                    dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + color[i][0];
                }
                if (dp[i-1][0] != Integer.MAX_VALUE || dp[i-1][2] != Integer.MAX_VALUE) {
                    dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + color[i][1];
                }
                if (dp[i-1][0] != Integer.MAX_VALUE || dp[i-1][1] != Integer.MAX_VALUE) {
                    dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + color[i][2];
                }
            }

            for (int end = 0; end < 3; end++) {
                if (start != end) {
                    answer = Math.min(answer, dp[n-1][end]);
                }
            }
        }

        System.out.println(answer);
    }
}
