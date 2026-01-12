package boj;

import java.io.*;

// 2631
public class lineUp {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        int ans = n - max;

        System.out.println(ans);
    }
}
