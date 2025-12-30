package programmers.level2;

import java.util.*;

public class delivery {
    static class Node {
        int to;
        int w;
        Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
    public int solution(int N, int[][] road, int K) {
        List<Node>[] graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < road.length; i++) {
            int[] now = road[i];
            int a = now[0];
            int b = now[1];
            int w = now[2];
            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        int[] dp = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) ->(a.w - b.w));
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int nowTo = node.to;
            int nowWe = node.w;
            visited[nowTo] = true;

            for (int j = 0; j < graph[nowTo].size(); j++) {
                Node newNode = graph[nowTo].get(j);

                if (!visited[newNode.to]) {
                    if (dp[newNode.to] > dp[nowTo] + newNode.w) {
                        dp[newNode.to] = dp[nowTo] + newNode.w;
                        pq.add(new Node(newNode.to, dp[newNode.to]));
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (dp[i] <= K) ans++;
        }

        return ans;
    }
}
