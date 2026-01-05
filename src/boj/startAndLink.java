package boj;

import java.io.*;
import java.util.*;

// 14889
public class startAndLink {
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int tempRes = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(n, n / 2, 0);

        System.out.println(min);
    }
    public static void comb(int n, int c, int start) {
        if (c == 0) {
            List<Integer> startLi = new ArrayList<>();
            List<Integer> linkLi = new ArrayList<>();

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    startLi.add(i);
                } else {
                    linkLi.add(i);
                }
            }
            boolean[] v1 = new boolean[startLi.size()];
            boolean[] v2 = new boolean[linkLi.size()];
            tempRes = 0;
            cal(startLi, 0, v1, 0);
            int tempA = tempRes;
            tempRes = 0;
            cal(linkLi, 0, v2, 0);
            int tempB = tempRes;
            min = Math.min(min, (int)Math.abs(tempA - tempB));
            return;
        }
        for (int i = start; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb(n, c-1, i+1);
                visited[i] = false;
            }
        }
    }
    public static void cal(List<Integer> li, int start, boolean[] v, int cnt) {
        if (cnt == 2) {
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < v.length; i++) {
                if (v[i]) {
                    q.add(li.get(i));
                }
            }
            int a = q.poll();
            int b = q.poll();
            tempRes = tempRes + arr[a][b] + arr[b][a];
            return;
        }
        for (int i = start; i < li.size(); i++) {
            if (!v[i]) {
                v[i] = true;
                cal(li, i+1, v, cnt+1);
                v[i] = false;
            }
        }
    }
}
