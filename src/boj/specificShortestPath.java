package boj;

import java.io.*;
import java.util.*;

// 1504
public class specificShortestPath {
    static class Node {
        int to;
        int w;
        Node (int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
    static List<Node>[] graph;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        st = new StringTokenizer(bf.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int oneToU = dij(1, u);
        int uToV = dij(u, v);
        int vToN = dij(v, n);
        int oneToV = dij(1, v);
        int vToU = dij(v, u);
        int uToN = dij(u, n);

        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;
        if (oneToU != -1 && uToV != -1 && vToN != -1) minA = oneToU + uToV + vToN;
        if (oneToV != -1 && vToU != -1 && uToN != -1) minB = oneToV + vToU + uToN;
        int min = Math.min(minA, minB);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
    public static int dij(int start, int fin) {
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
                if(dp[node.to] != Integer.MAX_VALUE) {
                    if (dp[newNode.to] > dp[node.to] + newNode.w) {
                        dp[newNode.to] = dp[node.to] + newNode.w;
                        pq.add(new Node(newNode.to, dp[newNode.to]));
                    }
                }
            }
        }

        if (dp[fin] != Integer.MAX_VALUE) {
            return dp[fin];
        } else {
            return -1;
        }
    }
}