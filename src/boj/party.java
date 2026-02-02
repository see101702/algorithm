package boj;

import java.util.*;
import java.io.*;

// 1238
public class party {
    static class Node {
        int to;
        int w;
        Node (int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
    static int n;
    static List<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, weight));
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int temp = dij(i, x) + dij(x, i);
            max = Math.max(temp, max);
        }
        System.out.println(max);
    }
    public static int dij(int start, int end) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.w));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            List<Node> li = graph[node.to];

            for (int i = 0; i < li.size(); i++) {
                Node newNode = li.get(i);

                if (dp[node.to] != Integer.MAX_VALUE) {
                    if (dp[newNode.to] > dp[node.to] + newNode.w) {
                        dp[newNode.to] = dp[node.to] + newNode.w;
                        pq.add(new Node(newNode.to, dp[newNode.to]));
                    }
                }
            }
        }

        if (dp[end] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[end];
        }
    }
}
