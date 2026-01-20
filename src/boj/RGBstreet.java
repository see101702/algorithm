package boj;

import java.util.*;
import java.io.*;

// 1149
public class RGBstreet {
    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] color = new int[n][3];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            color[i][0] = Integer.parseInt(st.nextToken());
            color[i][1] = Integer.parseInt(st.nextToken());
            color[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int start = 0; start < 3; start++) {
            int[][] dp = new int[n][3];
            for (int i = 0; i < 3; i++) {
                if (i == start) {
                    dp[0][start] = color[0][start];
                } else {
                    dp[0][i] = INF;
                }
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + color[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + color[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + color[i][2];
            }

            for (int i = 0; i < 3; i++) {
                ans = Math.min(ans, dp[n-1][i]);
            }
        }

        System.out.println(ans);
    }
}
