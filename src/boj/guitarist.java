package boj;

import java.io.*;
import java.util.*;

//1495
public class guitarist {
    static int n, s, m;
    static int[] v;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = new int[n+1];
        dp = new boolean[n+1][m+1];
        dp[0][s] = true;

        st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= m; j++) {
                if (dp[i-1][j]) {
                    if(j + v[i] <= m) {
                        dp[i][j + v[i]] = true;
                    }
                    if (j - v[i] >= 0) {
                        dp[i][j - v[i]] = true;
                    }
                }
            }
        }

        int answer = -1;

        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}