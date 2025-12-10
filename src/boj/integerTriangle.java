package boj;

import java.io.*;
import java.util.*;

public class integerTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i-1][i-1] + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1] + arr[i][j], dp[i-1][j] + arr[i][j]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < dp[n-1].length; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }

        System.out.println(answer);
    }
}