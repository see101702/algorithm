package programmers.level2;

// 비밀 코드 해독

public class crackTheCode {
    static boolean[] visited;
    static int answer;
    public int solution(int n, int[][] q, int[] ans) {
        visited = new boolean[n];
        answer = 0;
        comb(n, 0, 5, q, ans);

        return answer;
    }
    public static void comb(int n, int start, int cnt, int[][] q, int[] ans) {
        if (cnt == 0) {
            calc(q, ans);
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(n, i+1, cnt-1, q, ans);
            visited[i] = false;
        }
    }
    public static void calc(int[][] q, int[] ans) {

        boolean finalFlag = true;

        for (int i = 0; i < q.length; i++) {
            int[] now = q[i];
            int cnt = 0;
            for (int j = 0; j < now.length; j++) {
                if (visited[now[j]-1]) cnt++;
            }
            if (cnt != ans[i]) {
                finalFlag = false;
                break;
            }
        }

        if (finalFlag) answer++;
    }
}
