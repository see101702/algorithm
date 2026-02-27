package codetree.samsung;

import java.util.*;
import java.io.*;

// AI 로봇청소기
public class aiRobotVacuumCleaner {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static List<int[]> li;
    static List<int[]> newLi;
    static int n;
    static int[][] arr;
    static boolean[][] dvisited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > 0) sum += arr[i][j];
            }
        }

        dvisited = new boolean[n][n];
        li = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            li.add(new int[] {x-1, y-1});
            dvisited[x-1][y-1] = true;
        }

        for (int i = 0; i < l; i++) {
            newLi = new ArrayList<>();
            // dvisited = new boolean[n][n];
            // 이동
            for (int j = 0; j < k; j++) {
                int[] now = li.get(j);
                if (arr[now[0]][now[1]] > 0) {
                    newLi.add(new int[] {now[0], now[1]});
                } else {
                    bfs(now[0], now[1]);
                }
            }
            // 청소
            for (int j = 0; j < newLi.size(); j++) {
                int[] now = newLi.get(j);
                int idx = -1;
                int tsum = 0;
                int max = -1;

                for (int m = 0; m < 4; m++) {
                    if (arr[now[0]][now[1]] > 20) tsum = 20;
                    else tsum = arr[now[0]][now[1]];
                    for (int t = 0; t < 4; t++) {
                        if (m == t) continue;
                        int newX = now[0] + dx[t];
                        int newY = now[1] + dy[t];

                        if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;
                        if (arr[newX][newY] > 0) {
                            if (arr[newX][newY] > 20) tsum += 20;
                            else tsum += arr[newX][newY];
                        }
                    }

                    if (max < tsum) {
                        idx = m;
                        max = tsum;
                    }
                }

                if (arr[now[0]][now[1]] > 20) {
                    arr[now[0]][now[1]] -= 20;
                    sum -= 20;
                } else {
                    sum -= arr[now[0]][now[1]];
                    arr[now[0]][now[1]] = 0;
                }

                for (int m = 0; m < 4; m++) {
                    if (m == idx) continue;

                    int newX = now[0] + dx[m];
                    int newY = now[1] + dy[m];

                    if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;

                    if (arr[newX][newY] > 0) {
                        if (arr[newX][newY] > 20) {
                            arr[newX][newY] -= 20;
                            sum -= 20;
                        }
                        else {
                            sum -= arr[newX][newY];
                            arr[newX][newY] = 0;
                        }
                    }
                }
            }
            // 먼지축적
            for (int s = 0; s < n; s++) {
                for (int t = 0; t < n; t++) {
                    if (arr[s][t] > 0) {
                        arr[s][t] += 5;
                        sum += 5;
                    }
                }
            }
            // 확산
            int[][] add = new int[n][n];
            for (int s = 0; s < n; s++) {
                for (int t = 0; t < n; t++) {
                    if (arr[s][t] == 0) {
                        int stt = 0;
                        for (int u = 0; u < 4; u++) {
                            int newX = s + dx[u];
                            int newY = t + dy[u];

                            if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;
                            if (arr[newX][newY] == -1) continue;
                            stt += arr[newX][newY];
                        }
                        if (stt < 10) continue;
                        int c = stt / 10;
                        add[s][t] += c;
                        sum += c;
                    }
                }
            }
            for (int s = 0; s < n; s++) {
                for (int t = 0; t < n; t++) {
                    arr[s][t] += add[s][t];
                }
            }

            li.clear();
            for (int[] el : newLi) {
                li.add(new int[] {el[0], el[1]});
            }

            System.out.println(sum);
        }
    }
    public static void bfs(int x, int y) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a)
                        -> a[0]).thenComparingInt(a->a[1])
                .thenComparingInt(a->a[2]));
        pq.add(new int[] {0, x, y});
        boolean[][] visited = new boolean[n][n];
        visited[x][y] = true;

        boolean flag = false;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int d = now[0];
            int xx = now[1];
            int yy = now[2];

            if (d > 0 && arr[xx][yy] > 0) {
                dvisited[x][y] = false;
                dvisited[xx][yy] = true;
                newLi.add(new int[] {xx, yy});
                flag = true;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newX = xx + dx[i];
                int newY = yy + dy[i];

                if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;
                if (!dvisited[newX][newY] && !visited[newX][newY] && arr[newX][newY] != -1) {
                    if (arr[newX][newY] >= 0) {
                        pq.add(new int[] {d+1, newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        if (!flag) {
            dvisited[x][y] = true;
            newLi.add(new int[] {x, y});
        }
    }
}
