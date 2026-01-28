package boj;

import java.util.*;
import java.io.*;

// 2458
public class byHeight {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dp[a][b] = -1;
            dp[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <=n; k++) {
                    if (dp[j][i] == 1 && dp[i][k] == 1) {
                        dp[j][k] = 1;
                        dp[k][j] = -1;
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int len = 0;
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] != 0) len++;
            }
            if (len == n-1) cnt++;
        }

        System.out.println(cnt);
    }
}