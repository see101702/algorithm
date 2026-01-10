package programmers.level3;

// 파괴되지 않은 건물
public class undestroyedBuilding {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] arr = new int[n+1][m+1];

        for (int i = 0; i < skill.length; i++) {
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = (skill[i][0] == 1 ? (skill[i][5] * -1): skill[i][5]);

            arr[r1][c1] += degree;
            arr[r1][c2+1] -= degree;
            arr[r2+1][c1] -= degree;
            arr[r2+1][c2+1] += degree;
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] += arr[i][j-1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                arr[i][j] += arr[i-1][j];
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + arr[i][j] > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
