package programmers.level3;

import java.util.*;

// 블록 이동하기
public class moveBlock {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][][][] visited = new boolean[n][n][n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,0,1,0});
        visited[0][0][0][1] = true;
        int ans = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if ((now[0] == n-1 && now[1] == n-1) || (now[2] == n-1 && now[3] == n-1)) {
                ans = now[4];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX1 = now[0] + dx[i];
                int newY1 = now[1] + dy[i];
                int newX2 = now[2] + dx[i];
                int newY2 = now[3] + dy[i];
                int cnt = now[4];

                if (newX1 < 0 || newX1 >= n || newY1 < 0 || newY1 >= n
                        || newX2 < 0 || newX2 >= n || newY2 < 0 || newY2 >= n) continue;

                if (board[newX1][newY1] == 0 && board[newX2][newY2] == 0
                        && !visited[newX1][newY1][newX2][newY2]) {
                    q.add(new int[] {newX1, newY1, newX2, newY2, cnt+1});
                    visited[newX1][newY1][newX2][newY2] = true;
                }

                // 가로
                if (now[0] == now[2]) {
                    if(now[3] > 0 && now[2] < n-1 && board[now[2]+1][now[3]-1] == 0
                            && board[now[2]+1][now[3]] == 0 && !visited[now[0]][now[1]][now[2]+1][now[3]-1]) {
                        q.add(new int[] {now[0], now[1], now[2]+1, now[3]-1, now[4]+1});
                        visited[now[0]][now[1]][now[2]+1][now[3]-1] = true;
                    }
                    if (now[2] > 0 && now[3] > 0 && board[now[2]-1][now[3]-1] == 0
                            && board[now[2]-1][now[3]] == 0 && !visited[now[2]-1][now[3]-1][now[0]][now[1]]) {
                        q.add(new int[] {now[2]-1, now[3]-1, now[0], now[1], now[4]+1});
                        visited[now[2]-1][now[3]-1][now[0]][now[1]] = true;
                    }
                    if (now[0] < n-1 && now[1] < n-1 && board[now[0]+1][now[1]+1] == 0
                            && board[now[0]+1][now[1]] == 0 && !visited[now[2]][now[3]][now[0]+1][now[1]+1]) {
                        q.add(new int[] {now[2], now[3], now[0] + 1, now[1] + 1, now[4] + 1});
                        visited[now[2]][now[3]][now[0]+1][now[1]+1] = true;
                    }
                    if (now[0] > 0 && now[1] < n-1 && board[now[0]-1][now[1]+1] == 0
                            && board[now[0]-1][now[1]] == 0 && !visited[now[0]-1][now[1]+1][now[2]][now[3]]) {
                        q.add(new int[] {now[0]-1, now[1]+1, now[2], now[3], now[4] + 1});
                        visited[now[0]-1][now[1]+1][now[2]][now[3]] = true;
                    }
                }
                //세로
                if (now[1] == now[3]) {
                    if (now[0] < n-1 && now[1] < n-1 && board[now[0]+1][now[1]+1] == 0
                            && board[now[0]][now[1]+1] == 0 && !visited[now[2]][now[3]][now[0]+1][now[1]+1]) {
                        q.add(new int[] {now[2], now[3], now[0]+1, now[1]+1, now[4]+1});
                        visited[now[2]][now[3]][now[0]+1][now[1]+1] = true;
                    }
                    if (now[2] > 0 && now[3] < n-1 && board[now[2]-1][now[3]+1] == 0
                            && board[now[2]][now[3]+1] == 0 && !visited[now[0]][now[1]][now[2]-1][now[3]+1]) {
                        q.add(new int[] {now[0], now[1], now[2]-1, now[3]+1, now[4]+1});
                        visited[now[0]][now[1]][now[2]-1][now[3]+1] = true;
                    }
                    if (now[0] < n-1 && now[1] > 0 && board[now[0]+1][now[1]-1] == 0
                            && board[now[0]][now[1]-1] == 0 && !visited[now[0]+1][now[1]-1][now[2]][now[3]]) {
                        q.add(new int[] {now[0]+1, now[1]-1, now[2], now[3], now[4]+1});
                        visited[now[0]+1][now[1]-1][now[2]][now[3]] = true;
                    }
                    if (now[2] > 0 && now[3] > 0 && board[now[2]-1][now[3]-1] == 0
                            && board[now[2]][now[3]-1] == 0 && !visited[now[2]-1][now[3]-1][now[0]][now[1]]) {
                        q.add(new int[] {now[2]-1, now[3]-1, now[0], now[1], now[4]+1});
                        visited[now[2]-1][now[3]-1][now[0]][now[1]] = true;
                    }
                }
            }
        }

        return ans;
    }
}
