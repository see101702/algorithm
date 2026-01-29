package boj;

import java.io.*;
import java.util.*;

// 14503
public class robotVacuum {
    static int[][] arr;
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        ans = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleanUp(r, c, d);

        System.out.println(ans);
    }
    public static void cleanUp(int x, int y, int d) {
        if (arr[x][y] == 0) {
            ans++;
            arr[x][y] = 2;
        }

        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
            if (arr[newX][newY] == 0) {
                flag = true;
                break;
            }
        }
        if (flag) {
            int newD = 0;
            if (d == 0) newD = 3;
            else newD = d - 1;

            int finalX = x + dx[newD];
            int finalY = y + dy[newD];
            if (arr[finalX][finalY] == 0) {
                cleanUp(finalX, finalY, newD);
            } else {
                cleanUp(x, y, newD);
            }
        } else {
            int newD = (d+2) % 4;
            int finalX = x + dx[newD];
            int finalY = y + dy[newD];

            if (!(finalX < 0 || finalX >= n || finalY < 0 || finalY >= m || arr[finalX][finalY] == 1)) {
                cleanUp(finalX, finalY, d);
            } else {
                return;
            }
        }
    }
}
