package boj;

import java.io.*;
import java.util.*;

public class gasStation {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long[] distance = new long[n-1];
        long[] price = new long[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n-1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long total = distance[0]*price[0];
        int idx = 0;

        for (int i = 1; i < n-1; i++) {
            if (price[idx]*distance[i] > price[i]*distance[i]) {
                total += price[i]*distance[i];
                idx = i;
            } else {
                total += price[idx]*distance[i];
            }
        }

        System.out.println(total);
    }
}