package boj;

import java.io.*;
import java.util.*;

// 10942
public class palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(bf.readLine());

        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i+1]) {
                dp[i][i+1] = 1;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                if (arr[i] == arr[j] && dp[i+1][j-1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e]).append('\n');
        }

        System.out.println(sb);
    }
}
