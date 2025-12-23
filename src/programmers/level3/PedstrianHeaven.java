package programmers.level3;

// 보행자 천국
public class PedstrianHeaven {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];
        right[0][0] = 1;
        down[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 1) continue;

                if (i == 0 && j == 0) continue;

                if (j > 0) {
                    if (cityMap[i][j-1] == 2) {
                        right[i][j] = (right[i][j] + right[i][j-1]) % MOD;
                    } else {
                        right[i][j] = (right[i][j] + right[i][j-1] + down[i][j-1]) % MOD;
                    }
                }

                if (i > 0) {
                    if (cityMap[i-1][j] == 2) {
                        down[i][j] = (down[i][j] + down[i-1][j]) % MOD;
                    } else {
                        down[i][j] = (down[i][j] + down[i-1][j] + right[i-1][j]) % MOD;
                    }
                }
            }
        }

        int ans = (right[m-1][n-1] + down[m-1][n-1]) % MOD;

        return ans;
    }
}
