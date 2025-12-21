package boj;

import java.io.*;
import java.util.*;

//3055
public class escape {
    static char[][] arr;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
    static int r, c, finalX, finalY;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        visited = new int[r][c];

        finalX = 0;
        finalY = 0;

        for (int i = 0; i < r; i++) {
            String str = bf.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == '*') {
                    q.add(new int[] {0, i, j});
                }
                if (arr[i][j] == 'S') {
                    q.add(new int[] {1, i, j});
                }
                if (arr[i][j] == 'D') {
                    finalX = i;
                    finalY = j;
                }
            }
        }

        bfs();

        if (visited[finalX][finalY] == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(visited[finalX][finalY]);
        }
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int w = now[0];
            int x = now[1];
            int y = now[2];

            if (w == 1 && x == finalX && y == finalY) return;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX < 0 || newX >= r || newY < 0 || newY >= c) continue;

                if (w % 2 == 0 && arr[newX][newY] != 'X' && arr[newX][newY] != 'D' && arr[newX][newY] != '*') {
                    q.add(new int[] {w+2, newX, newY});
                    arr[newX][newY] = '*';
                }

                if (w % 2 == 1 && arr[newX][newY] != 'X' && arr[newX][newY] != '*' && visited[newX][newY] == 0) {
                    q.add(new int[] {w+2, newX, newY});
                    visited[newX][newY] = visited[x][y] + 1;
                }
            }
        }
    }
}
