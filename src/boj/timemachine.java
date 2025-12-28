package boj;

import java.io.*;
import java.util.*;

//11657
public class timemachine {
    static class Node {
        int to;
        int w;
        Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Node>[] graph = new ArrayList[n+1];
        long[] dp = new long[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, w));
        }

        dp[1] = 0;
        int cnt = 0;

        while (true) {
            cnt++;
            for (int i = 1; i <= n; i++) {
                List<Node> now = graph[i];

                for (int j = 0; j < now.size(); j++) {
                    Node node = now.get(j);
                    if (dp[i] != Integer.MAX_VALUE) {
                        if (dp[node.to] > dp[i] + node.w) {
                            dp[node.to] = dp[i] + node.w;
                            if (cnt == n) {
                                System.out.println(-1);
                                return;
                            }
                        }
                    }
                }
            }
            if (cnt == n) {
                break;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dp[i]);
            }
        }
    }
}
