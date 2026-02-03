package boj;

import java.io.*;
import java.util.*;

// 20055
public class conveyorBelt {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[2*n];
        int[] robot = new int[2*n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 2*n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        while (true) {
            cnt++;

            int temp = arr[2*n-1];
            int tempRobot = robot[2*n-1];
            for (int i = 2*n -1; i >= 0; i--) {
                if (i == 0) {
                    arr[i] = temp;
                    robot[i] = tempRobot;
                } else {
                    arr[i] = arr[i - 1];
                    robot[i] = robot[i - 1];
                    if (i == n-1) robot[i] = 0;
                }
            }
            if (robot[2*n -1] == 1) robot[2*n -1] = 0;

            for (int i = 2*n -1; i >= 0; i--) {
                if (robot[i] == 1) {
                    if (i < 2*n -1 && robot[i+1] == 0 && arr[i+1] > 0) {
                        robot[i] = 0;
                        robot[i+1] = 1;
                        arr[i+1]--;
                        if (i+1 == n-1) robot[i+1] = 0;
                    }
                }
            }

            if (arr[0] > 0) {
                robot[0] = 1;
                arr[0]--;
            }

            int num = 0;
            for (int i = 0; i < 2*n; i++) {
                if (arr[i] == 0) num++;
            }
            if (num >= k) break;
        }

        System.out.println(cnt);
    }
}
