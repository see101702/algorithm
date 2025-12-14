package boj;

import java.io.*;
import java.util.*;

//14502
public class lab {
    static int n, m;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static List<int[]> li = new ArrayList<>();
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    li.add(new int[] {i, j});
                }
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int cnt) {
        if (cnt == 3) {
            visited = new boolean[n][m];
            int[][] copy = new int[n][m];
            for (int i = 0; i < n; i++) {
                copy[i] = arr[i].clone();
            }

            bfs(copy);
            int sum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copy[i][j] == 0) {
                        sum++;
                    }
                }
            }

            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(cnt+1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(int[][] copy) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < li.size(); i++) {
            q.add(li.get(i));
            visited[li.get(i)[0]][li.get(i)[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = now[0] + dx[i];
                int newY = now[1] + dy[i];

                if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;

                if (copy[newX][newY] == 0 && !visited[newX][newY]) {
                    copy[newX][newY] = 2;
                    q.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }
}
