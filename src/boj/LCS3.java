package boj;

import java.io.*;

// 1958
public class LCS3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bf.readLine();
        String str2 = bf.readLine();
        String str3 = bf.readLine();

        int[][][] dp = new int[str1.length()+1][str2.length()+1][str3.length()+1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                for (int t = 1; t <= str3.length(); t++) {
                    if (str1.charAt(i-1) == str2.charAt(j-1) && str2.charAt(j-1) == str3.charAt(t-1)) {
                        dp[i][j][t] = Math.max(dp[i][j][t], dp[i-1][j-1][t-1] + 1);
                    } else {
                        dp[i][j][t] = Math.max(dp[i-1][j][t], Math.max(dp[i][j-1][t], dp[i][j][t-1]));
                    }
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()][str3.length()]);
    }
}
