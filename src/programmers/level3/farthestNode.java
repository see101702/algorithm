package programmers.level3;

import java.util.*;

// 가장 먼 노드
public class farthestNode {
    static class Node {
        int to;
        int w;
        Node (int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
    public int solution(int n, int[][] edge) {
        int[] dp = new int[n+1];
        List<Node>[] graph = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        dp[1] = 0;
        int max = 0;

        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];

            graph[a].add(new Node(b, 1));
            graph[b].add(new Node(a, 1));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            visited[node.to] = true;
            List<Node> li = graph[node.to];

            for (int i = 0; i < li.size(); i++) {
                Node newNode = li.get(i);

                if (!visited[newNode.to] && dp[node.to] != Integer.MAX_VALUE) {
                    if (dp[newNode.to] > dp[node.to] + newNode.w) {
                        dp[newNode.to] = dp[node.to] + newNode.w;
                        max = Math.max(max, dp[newNode.to]);
                        pq.add(new Node(newNode.to, dp[newNode.to]));
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] == max) ans++;
        }

        return ans;
    }
}
