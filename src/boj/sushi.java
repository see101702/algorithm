package boj;

import java.io.*;
import java.util.*;

// 2531
public class sushi {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        int start = 0;
        int last = start + k;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = start; i < last; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        map.put(c, map.getOrDefault(c, 0) + 1);
        int max = map.size();

        if (max == k+1) {
            System.out.println(max);
            return;
        }

        while (start < n - 1) {
            if (last >= n) last -= n;

            map.put(arr[start], map.get(arr[start]) - 1);
            if (map.get(arr[start]) == 0) map.remove(arr[start]);

            map.put(arr[last], map.getOrDefault(arr[last], 0) + 1);

            map.put(c, map.getOrDefault(c, 0) + 1);

            max = Math.max(max, map.size());

            if (max == k+1) {
                System.out.println(max);
                return;
            }
            start++;
            last++;
        }

        System.out.println(max);
    }
}
