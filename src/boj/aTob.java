package boj;

import java.io.*;
import java.util.*;

public class aTob {
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        answer = -1;
        search(a, 1, b);

        System.out.println(answer);
    }

    public static void search(long start, int cnt, int b) {
        if (start == b) {
            answer = cnt;
            return;
        }
        if (start > b) {
            return;
        }
        String str = start + "1";
        search(start*2, cnt+1, b);
        search(Long.parseLong(str), cnt+1, b);
    }
}
