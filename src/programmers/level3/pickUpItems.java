package programmers.level3;

import java.util.*;

//아이템줍기
public class pickUpItems {
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        visited = new boolean[101][101];

        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;

            for (int s = x1; s <= x2; s++) {
                for (int t = y1; t <= y2; t++) {
                    map[s][t] = 1;
                }
            }
        }

        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;

            for (int s = x1 + 1; s < x2; s++) {
                for (int t = y1 + 1; t < y2; t++) {
                    map[s][t] = 2;
                }
            }
        }

        int answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2) / 2;

        return answer;
    }

    public static int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {characterX, characterY, 0});
        visited[characterX][characterY] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == itemX && now[1] == itemY) {
                return now[2];
            }

            for (int i = 0; i < 4; i++) {
                int newX = now[0] + dx[i];
                int newY = now[1] + dy[i];

                if (newX < 0 || newX > 100 || newY < 0 || newY > 100) continue;

                if (map[newX][newY] == 1 && !visited[newX][newY]) {
                    q.add(new int[] {newX, newY, now[2]+1});
                    visited[newX][newY] = true;
                }
            }
        }

        return -1;
    }
}
