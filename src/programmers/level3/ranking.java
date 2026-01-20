package programmers.level3;

// 순위
public class ranking {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n+1][n+1];

        for (int i = 0; i < results.length; i++) {
            int w = results[i][0];
            int l = results[i][1];

            graph[w][l] = 1;
            graph[l][w] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (graph[j][i] == 1 && graph[i][k] == 1) {
                        graph[j][k] = 1;
                        graph[k][j] = -1;
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i ++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != 0) cnt++;
            }
            if (cnt == n-1) ans++;
        }

        return ans;
    }
}