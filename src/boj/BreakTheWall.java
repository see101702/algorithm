package boj;

import java.io.*;
import java.util.*;

//2206
public class BreakTheWall {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][][] visited;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String str = bf.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int answer = bfs(arr);

        System.out.println(answer);
    }

    public static int bfs(int[][] arr) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 0});
        visited[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int w = now[2];

            if (x == n-1 && y == m-1) {
                return visited[x][y][w];
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;

                if (arr[newX][newY] == 0 && visited[newX][newY][w] == 0) {
                    q.add(new int[] {newX, newY, w});
                    visited[newX][newY][w] = visited[x][y][w] + 1;
                }

                if (arr[newX][newY] == 1 && w == 0 && visited[newX][newY][1] == 0) {
                    q.add(new int[] {newX, newY, 1});
                    visited[newX][newY][1] = visited[x][y][w] + 1;
                }
            }
        }

        return -1;

    }
}