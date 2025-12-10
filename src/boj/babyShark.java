package boj;

import java.io.*;
import java.util.*;

//16236
public class babyShark {
    static int[][] arr;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int n, x, y, w;
    static int nowNum;
    static int sum;
    static List<int[]> li = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        w = 2;
        nowNum = 0;
        sum = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 9) {
                    x = i;
                    y = j;
                }
            }
        }

        arr[x][y] = 0;

        while (true) {
            int[][] visited = new int[n][n];
            bfs(x,y, visited);
            if (li.size() == 0) break;
            li.sort(Comparator.comparingInt((int[] arr) -> arr[0])
                    .thenComparingInt(arr -> arr[1])
                    .thenComparingInt(arr -> arr[2]));
            sum += li.get(0)[0];
            x = li.get(0)[1];
            y = li.get(0)[2];
            arr[x][y] = 0;
            li = new ArrayList<>();
            nowNum++;
            if (nowNum == w) {
                w++;
                nowNum = 0;
            }
        }

        System.out.println(sum);
    }

    public static void bfs(int a, int b, int[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {a, b});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (arr[now[0]][now[1]] < w && arr[now[0]][now[1]] != 0) {
                li.add(new int[] {visited[now[0]][now[1]], now[0], now[1]});
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newX = now[0] + dx[i];
                int newY = now[1] + dy[i];

                if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;

                if (visited[newX][newY] == 0 && arr[newX][newY] <= w) {
                    q.add(new int[] {newX, newY});
                    visited[newX][newY] = visited[now[0]][now[1]] + 1;
                }
            }
        }
    }
}
