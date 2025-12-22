package boj;

import java.io.*;
import java.util.*;

//1916
public class minimumCost {
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
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        List<Node>[] graph = new ArrayList[n+1];
        int[] dp = new int[n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dp[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowTo = now.to;
            int nowW = now.w;
            visited[nowTo] = true;
            List<Node> li = graph[nowTo];

            if (nowTo == end) break;

            for (int i = 0; i < li.size(); i++) {
                Node newNode = li.get(i);
                if (nowW + newNode.w < dp[newNode.to]) {
                    pq.add(new Node(newNode.to, nowW + newNode.w));
                    dp[newNode.to] = nowW + newNode.w;
                }
            }
        }
        System.out.println(dp[end]);
    }
}
