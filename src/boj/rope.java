package boj;

import java.io.*;
import java.util.*;

public class rope {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int total = 0;

        for (int i = 0; i < n; i++) {
            total = Math.max(total, arr[i]*(i+1));
        }

        System.out.println(total);
    }
}
