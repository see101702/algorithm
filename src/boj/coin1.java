package boj;

import java.io.*;
import java.util.*;

//2293
public class coin1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] dp = new int[k+1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j <= k; j++) {
                dp[j] += dp[j-arr[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
