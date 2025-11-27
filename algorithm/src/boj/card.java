package boj;

import java.io.*;
import java.util.*;
//1715
public class card {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(bf.readLine()));
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int sum = a + b;

            answer += sum;
            pq.add(sum);
        }

        System.out.println(answer);
    }
}