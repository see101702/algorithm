package boj;

import java.io.*;
import java.util.*;

//2606
public class virus {
    static boolean[] visited;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int lineNum = Integer.parseInt(bf.readLine());
        int[][] arr = new int[lineNum*2][2];
        visited = new boolean[n+1];

        for (int i = 0; i < lineNum*2; i+=2) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i+1][0] = b;
            arr[i+1][1] = a;
        }

        bfs(arr);

        System.out.println(cnt);
    }
    public static void bfs(int[][] arr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] == now && !visited[arr[i][1]]) {
                    q.add(arr[i][1]);
                    visited[arr[i][1]] = true;
                    cnt++;
                }
            }
        }
    }
}
