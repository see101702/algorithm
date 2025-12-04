package programmers;

public class pirodo {
    static int answer;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        answer = 0;

        dfs(dungeons, k, visited, 0);

        return answer;
    }

    public static void dfs(int[][] dungeons, int k, boolean[] visited, int cnt) {

        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                dfs(dungeons, k-dungeons[i][1], visited, cnt+1);
                visited[i] = false;
            }
        }

        answer = Math.max(answer, cnt);
    }
}
