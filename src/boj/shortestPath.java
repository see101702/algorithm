package boj;

import java.util.*;
import java.io.*;

//1753
public class shortestPath {
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
        int k = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(bf.readLine());

        List<Node>[] graph = new ArrayList[n+1];
        int[] dp = new int[n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }

        dp[start] = 0;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            visited[now.to] = true;

            for (int i = 0; i < graph[now.to].size(); i++) {
                Node newNode = graph[now.to].get(i);
                if (!visited[newNode.to] && dp[newNode.to] > dp[now.to] + newNode.w
                        && dp[now.to] != Integer.MAX_VALUE) {
                    dp[newNode.to] = dp[now.to] + newNode.w;
                    pq.add(new Node(newNode.to, dp[newNode.to]));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dp[i]);
            }
        }
    }
}
