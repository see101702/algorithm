package boj;

import java.io.*;
import java.util.*;

//16234
public class populationMove {
    static int[][] arr;
    static boolean[][] visited;
    static int n,l,r;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<int[]> li = new ArrayList<>();
    static int sum = 0;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[n][n];
            flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        li = new ArrayList<>();
                        sum = 0;
                        bfs(i, j);
                        for (int t = 0; t < li.size(); t++) {
                            int[] id = li.get(t);
                            arr[id[0]][id[1]] = sum / li.size();
                        }
                    }
                }
            }
            if (flag) {
                ans++;
            } else {
                break;
            }
        }
        System.out.println(ans);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        li.add(new int[] {x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = now[0] + dx[i];
                int newY = now[1] + dy[i];

                if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;

                if (!visited[newX][newY] && Math.abs(arr[now[0]][now[1]] - arr[newX][newY]) >= l
                        && Math.abs(arr[now[0]][now[1]] - arr[newX][newY]) <= r) {
                    li.add(new int[] {newX, newY});
                    q.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                    flag = true;
                }
            }
        }

        for (int i = 0; i < li.size(); i++) {
            int[] a = li.get(i);
            sum += arr[a[0]][a[1]];
        }
    }
}

