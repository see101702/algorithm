package programmers.level2;

// 서버 증설 횟수

public class serverExpansions {
    public int solution(int[] players, int m, int k) {
        int[] server = new int[24];
        int ans = 0;

        for (int i = 0; i < players.length; i++) {
            int n = players[i] / m;

            if (server[i] >= n) continue;

            int plus = n - server[i];
            for (int j = i; j < i + k; j++) {
                if (j < 24) {
                    server[j] += plus;
                }
            }
            ans += plus;
        }

        return ans;
    }
}
