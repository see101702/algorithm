package boj;

import java.util.*;
import java.io.*;

//2667
public class complexNumber {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        List<Integer> li = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = bf.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    int sum = bfs(i, j, n);
                    li.add(sum);
                }
            }
        }

        Collections.sort(li);
        System.out.println(li.size());
        for (int i = 0; i < li.size(); i++) {
            System.out.println(li.get(i));
        }

    }

    public static int bfs(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = now[0] + dx[i];
                int newY = now[1] + dy[i];

                if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;

                if (!visited[newX][newY] && arr[newX][newY] == 1) {
                    cnt++;
                    q.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }

        return cnt;
    }
}
