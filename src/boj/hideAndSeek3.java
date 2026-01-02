package boj;

import java.io.*;
import java.util.*;

//13549
public class hideAndSeek3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        int ans = Integer.MAX_VALUE;

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        q.add(new int[] {n, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            visited[now[0]] = true;

            if (now[0] == k) {
                ans = now[1];
                break;
            }

            int plusX = now[0] + 1;
            int minusX = now[0] - 1;
            int multiX = now[0] * 2;

            if (multiX <= 100000 && !visited[multiX]) {
                q.add(new int[] {multiX, now[1]});
            }
            if (plusX <= 100000 && !visited[plusX]) {
                q.add(new int[] {plusX, now[1]+1});
            }
            if (minusX >= 0 && !visited[minusX]) {
                q.add(new int[]{minusX, now[1] + 1});
            }
        }

        System.out.println(ans);

    }
}