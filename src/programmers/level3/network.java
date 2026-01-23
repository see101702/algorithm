package programmers.level3;

import java.util.*;

// 네트워크
public class network {
    static boolean[] visited;
    static int ans;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        ans = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
            }
        }

        return ans;
    }
    public static void bfs(int start, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < computers.length; i++) {
                if (!visited[i] && computers[now][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

        ans++;
    }
}
