package boj;

import java.io.*;
import java.util.*;

public class wordMath {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] arr = new String[n];
        int[] alphabet = new int[26];
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = bf.readLine();

            for (int j = 0; j < arr[i].length(); j++) {
                char c = arr[i].charAt(j);

                alphabet[c-'A'] += (int)Math.pow(10, arr[i].length() - 1 - j);
            }
        }
        Arrays.sort(alphabet);
        int num = 9;

        for (int i = 25; i >= 0; i--) {
            if (alphabet[i] <= 0) break;
            answer += num * alphabet[i];
            num--;
        }

        System.out.println(answer);

    }
}
