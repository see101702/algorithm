package programmers.level3;

import java.util.*;

// 기둥과 보 설치
public class PillarAndBeam {
    static boolean[][][] arr;
    public int[][] solution(int n, int[][] build_frame) {
        arr = new boolean[n+1][n+1][2];

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int w = build_frame[i][2];
            int f = build_frame[i][3];

            if (x < 0 || x > n || y < 0 || y > n) continue;

            if (f == 0) {
                arr[x][y][w] = false;
                if (!isValid(n)) arr[x][y][w] = true;
            }
            if (f == 1) {
                arr[x][y][w] = true;
                if (!isValid(n)) arr[x][y][w] = false;
            }
        }

        List<int[]> li = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k < 2; k++) {
                    if (arr[i][j][k]) li.add(new int[] {i, j, k});
                }
            }
        }
        li.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a-> a[1]).thenComparingInt(a->a[2]));
        int[][] result = new int[li.size()][3];

        for (int i = 0; i < li.size(); i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = li.get(i)[j];
            }
        }

        return result;
    }
    public static boolean isValid(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (arr[i][j][0]) {
                    if (!(j == 0 || arr[i][j][1] || (i > 0 && arr[i-1][j][1]) || (j > 0 && arr[i][j-1][0]))) return false;
                }
                if (arr[i][j][1]) {
                    if (!(((j > 0 && arr[i][j-1][0]) || (i < n && j > 0 && arr[i+1][j-1][0]))
                            || (i > 0 && i < n && arr[i-1][j][1] && arr[i+1][j][1]))) return false;
                }
            }
        }
        return true;
    }
}
