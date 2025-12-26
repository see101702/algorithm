package boj;

import java.io.*;
import java.util.*;

//5972
public class packageDelivery {
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
        List<Node>[] cows = new ArrayList[n+1];
        int[] dp = new int[n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            cows[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            cows[a].add(new Node(b, weight));
            cows[b].add(new Node(a, weight));
        }

        dp[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> (a.w-b.w));
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int to = now.to;
            int we = now.w;
            visited[to] = true;
            if (to == n) break;

            for (int i = 0; i < cows[to].size(); i++) {
                Node node = cows[to].get(i);
                if (!visited[node.to]) {
                    if (dp[to] != Integer.MAX_VALUE && dp[node.to] > dp[to] + node.w) {
                        dp[node.to] = dp[to] + node.w;
                        pq.add(new Node(node.to, dp[to] + node.w));
                    }
                }
            }
        }

        System.out.println(dp[n]);

    }
}
