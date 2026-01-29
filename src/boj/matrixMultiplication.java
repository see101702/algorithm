package boj;

import java.util.*;
import java.io.*;

// 11049
public class matrixMultiplication {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        int interval = 1;
        for (int i = interval; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                for (int k = j; k < j+i; k++) {
                    if (dp[j][k] != Integer.MAX_VALUE && dp[k+1][j+i] != Integer.MAX_VALUE) {
                        dp[j][j+i] = Math.min(dp[j][j+i], dp[j][k] + dp[k+1][j+i] + arr[j][0]*arr[k][1]*arr[j+i][1]);
                    }
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
}
