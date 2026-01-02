package boj;

import java.util.*;
import java.io.*;

//1865
public class wormhole {
    static class Node {
        int to;
        int we;
        Node (int to, int we) {
            this.to = to;
            this.we = we;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            List<Node>[] graph = new ArrayList[n+1];
            int[] dp = new int[n+1];
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
                dp[j] = 0;
            }
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                graph[a].add(new Node(b, weight));
                graph[b].add(new Node(a, weight));
            }
            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                graph[a].add(new Node(b, -1 * weight));
            }

            boolean flag = false;

            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    List<Node> li = graph[k];
                    for (int s = 0; s < li.size(); s++) {
                        Node now = li.get(s);
                        if (dp[k] != Integer.MAX_VALUE) {
                            if (dp[k] + now.we < dp[now.to]) {
                                dp[now.to] = dp[k] + now.we;
                                if (j == n) {
                                    flag = true;
                                }
                            }
                        }
                    }
                }
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}


