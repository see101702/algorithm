package boj;

import java.util.*;
import java.io.*;

//2294
public class coin2 {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        int[] dp = new int[k+1];

        dp[0] = 0;

        for (int i = 1; i <= k; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(bf.readLine());
        }

        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= k; j++) {
                if (dp[j-coin[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
                }
            }
        }

        if (dp[k] == Integer.MAX_VALUE) {
            dp[k] = -1;
        }

        System.out.println(dp[k]);
    }
}
