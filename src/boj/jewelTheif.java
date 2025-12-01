package boj;

import java.io.*;
import java.util.*;

//1202
public class jewelTheif {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] jewel = new int[n][2];
        int[] weights = new int[k];
        long answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            weights[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(jewel, Comparator.comparingInt((int[] o) -> o[0]));
        Arrays.sort(weights);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;

        for (int i = 0; i < k; i++) {
            int w = weights[i];

            while (idx < n && jewel[idx][0] <= w) {
                pq.add(jewel[idx][1]);
                idx++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}
