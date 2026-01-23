package boj;

import java.io.*;
import java.util.*;

// 21278
public class hoseokTwoChicken {
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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dp[a][b] = 1;
            dp[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][i] = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (dp[j][i] != Integer.MAX_VALUE && dp[i][k] != Integer.MAX_VALUE) {
                        dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
                    }
                }
            }
        }

        int first = n+1;
        int second = n+1;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                int temp = 0;
                for (int k = 1; k <= n; k++) {
                    int tempMin = Math.min(dp[k][i] + dp[i][k], dp[k][j] + dp[j][k]);
                    temp += tempMin;
                }
                if (min > temp) {
                    min = temp;
                    first = i;
                    second = j;
                } else if (min == temp) {
                    if (first > i) {
                        first = i;
                        second = j;
                    }
                    if (first == i) {
                        if (second > j) {
                            first = i;
                            second = j;
                        }
                    }
                }
            }
        }

        System.out.println(first + " " + second + " " + min);
    }
}
