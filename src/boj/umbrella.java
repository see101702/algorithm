package boj;

import java.io.*;
import java.util.*;

// 17244
public class umbrella {
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        int nowX = 0;
        int nowY = 0;
        int finX = 0;
        int finY = 0;
        List<int[]> li = new ArrayList<>();
        int[][] itemIdx = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = bf.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'S') {
                    nowX = i;
                    nowY = j;
                }
                if (arr[i][j] == 'X') {
                    li.add(new int[] {i, j});
                }
                if (arr[i][j] == 'E') {
                    finX = i;
                    finY = j;
                }
            }
        }

        int k = li.size();
        for (int i = 0; i < k; i++) {
            int[] now = li.get(i);
            itemIdx[now[0]][now[1]] = i;
        }

        int[][][] visited = new int[n][m][1<<k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) Arrays.fill(visited[i][j], -1);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {nowX, nowY, 0});
        visited[nowX][nowY][0] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int mask = now[2];

            if (x == finX && y == finY && mask == (1<<k)-1) {
                System.out.println(visited[x][y][mask]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                int newM = mask;

                if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
                if (arr[newX][newY] == '#') continue;
                if (arr[newX][newY] == 'X') {
                    int mTemp = 1 << itemIdx[newX][newY];
                    newM = mask | mTemp;
                }
                if (visited[newX][newY][newM] != -1) continue;
                q.add(new int[] {newX, newY, newM});
                visited[newX][newY][newM] = visited[x][y][mask] + 1;
            }
        }
    }
}
