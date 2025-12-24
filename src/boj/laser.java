package boj;

import java.io.*;
import java.util.*;

//6087
public class laser {
    static char[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int w, h;
    static int finalX, finalY;
    static int[][][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new char[h][w];
        dist = new int[h][w][4];
        int ans = Integer.MAX_VALUE;

        int startX = 0;
        int startY = 0;
        finalX = 0;
        finalY = 0;
        int cnt = 0;

        for (int i = 0; i < h; i++) {
            String str = bf.readLine();
            for (int j = 0; j < w; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'C' && cnt == 0) {
                    startX = i;
                    startY = j;
                    cnt++;
                } else if (arr[i][j] == 'C' && cnt == 1) {
                    finalX = i;
                    finalY = j;
                }
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[0]));
        for (int i = 0; i < 4; i++) {
            dist[startX][startY][i] = 0;
            pq.add(new int[] {0, i, startX, startY});
        }

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int cost = now[0];
            int dir = now[1];
            int x = now[2];
            int y = now[3];

            if (x == finalX && y == finalY) {
                ans = Math.min(ans, cost);
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                int newCost = cost;
                if (dir != i) {
                    newCost = cost + 1;
                }

                if (newX < 0 || newX >= h || newY < 0 || newY >= w) continue;

                if (arr[newX][newY] == '*') continue;

                if (dist[newX][newY][i] > newCost) {
                    dist[newX][newY][i] = newCost;
                    pq.add(new int[] {newCost, i, newX, newY});
                }
            }
        }

        System.out.println(ans);
    }
}