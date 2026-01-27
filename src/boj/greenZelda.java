package boj;

import java.io.*;
import java.util.*;

// 4485
public class greenZelda{
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int k = 0;
        while (true) {
            int n = Integer.parseInt(bf.readLine());
            if (n == 0) break;
            k++;

            int[][] arr = new int[n][n];
            int[][] dp = new int[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = arr[0][0];
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[]a) -> a[2]));
            pq.add(new int[] {0, 0, dp[0][0]});

            while (!pq.isEmpty()) {
                int[] now = pq.poll();

                for (int i = 0; i < 4; i++) {
                    int newX = now[0] + dx[i];
                    int newY = now[1] + dy[i];

                    if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;

                    if (dp[now[0]][now[1]] != Integer.MAX_VALUE
                            && dp[newX][newY] > dp[now[0]][now[1]] + arr[newX][newY]) {
                        dp[newX][newY] = dp[now[0]][now[1]] + arr[newX][newY];
                        pq.add(new int[] {newX, newY, dp[newX][newY]});
                    }

                }
            }

            System.out.println("Problem " + k + ": " + dp[n-1][n-1]);
        }
    }
}
