package boj;

import java.util.*;
import java.io.*;

// 1987
public class alphabet {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] arr;
    static int r, c, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        ans = 0;

        for (int i = 0; i < r; i++) {
            String str = bf.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        Set<Character> set = new HashSet<>();
        set.add(arr[0][0]);
        dfs(0, 0, 1, set);

        System.out.println(ans);
    }
    public static void dfs(int x, int y, int s, Set<Character> set) {

        ans = Math.max(ans, s);

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newX >= r || newY < 0 || newY >= c) continue;

            if (set.contains(arr[newX][newY])) continue;

            set.add(arr[newX][newY]);
            dfs(newX, newY, s+1, set);
            set.remove(arr[newX][newY]);
        }
    }
}
