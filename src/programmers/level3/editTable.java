package programmers.level3;

import java.util.*;

// 표편집
public class editTable {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] alive = new boolean[n];

        for (int i = 0; i < n; i++) {
            alive[i] = true;
        }

        Stack<Integer> st = new Stack<>();
        int now = k;

        for (int i = 0; i < n; i++) {
            prev[i] = i-1;
            if (i == n-1) {
                next[i] = -1;
            } else {
                next[i] = i+1;
            }
        }

        for (int i = 0; i < cmd.length; i++) {
            String str = cmd[i];

            if (str.charAt(0) == 'U') {
                for (int j = 0; j < Integer.parseInt(str.substring(2)); j++) {
                    now = prev[now];
                }
            } else if (str.charAt(0) == 'D') {
                for (int j = 0; j < Integer.parseInt(str.substring(2)); j++) {
                    now = next[now];
                }
            } else if (str.charAt(0) == 'C') {
                st.push(now);
                alive[now] = false;

                if (prev[now] != -1) next[prev[now]] = next[now];
                if (next[now] != -1) prev[next[now]] = prev[now];

                if (next[now] == -1) {
                    now = prev[now];
                } else {
                    now = next[now];
                }
            } else {
                int temp = st.pop();
                alive[temp] = true;

                if (prev[temp] != -1) next[prev[temp]] = temp;
                if (next[temp] != -1) prev[next[temp]] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alive.length; i++) {
            if (alive[i]) sb.append("O");
            else sb.append("X");
        }

        return sb.toString();
    }
}
