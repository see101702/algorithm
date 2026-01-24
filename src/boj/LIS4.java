package boj;

import java.util.*;
import java.io.*;

// 14002
public class LIS4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] prev = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prev[i] = -1;
        }

        int max = 1;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if(dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                        if (max < dp[i]) {
                            max = dp[i];
                            maxIdx = i;
                        }
                    }
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int tempIdx = maxIdx;
        while (tempIdx != -1) {
            stack.push(arr[tempIdx]);
            tempIdx = prev[tempIdx];
        }

        System.out.println(max);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
