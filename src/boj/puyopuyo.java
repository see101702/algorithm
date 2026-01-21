package boj;

import java.io.*;
import java.util.*;

// 11559
public class puyopuyo {
    static char[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[12][6];
        int ans = 0;
        boolean flag = false;

        for (int i = 0; i < 12; i++) {
            String str = bf.readLine();
            for (int j = 0; j < 6; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        while (true) {
            visited = new boolean[12][6];
            flag = false;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!visited[i][j] && arr[i][j] != '.') {
                        if (bfs(i, j)) {
                            flag = true;
                        }
                    }
                }
            }

            if (!flag) break;

            ans++;

            applyGravity();
        }

        System.out.println(ans);

    }
    public static boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> li = new ArrayList<>();
        q.add(new int[] {x, y});
        li.add(new int[] {x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = now[0] + dx[i];
                int newY = now[1] + dy[i];

                if (newX < 0 || newX >= 12 || newY < 0 || newY >= 6) continue;

                if (!visited[newX][newY] && arr[newX][newY] == arr[x][y]) {
                    q.add(new int[] {newX, newY});
                    li.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }

        if (li.size() >= 4) {
            for (int[] now : li) {
                arr[now[0]][now[1]] = '.';
            }
            return true;
        } else {
            return false;
        }
    }
    public static void applyGravity() {
        for (int i = 0; i < 6; i++) {
            Stack<Character> st = new Stack<>();

            for (int j = 0; j < 12; j++) {
                if (arr[j][i] != '.') {
                    st.push(arr[j][i]);
                }
            }

            for (int j = 11; j >= 0; j--) {
                if (st.size() > 0) {
                    char c = st.pop();
                    arr[j][i] = c;
                } else {
                    arr[j][i] = '.';
                }
            }
        }
    }
}
