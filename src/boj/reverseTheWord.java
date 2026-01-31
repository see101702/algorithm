package boj;

import java.io.*;
import java.util.*;

// 17413
public class reverseTheWord {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '<') {
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
                sb.append('<');
                flag = true;
            } else if (c == '>') {
                sb.append('>');
                flag = false;
            } else {
                if (flag) {
                    sb.append(c);
                } else {
                    if (c == ' ') {
                        while (!st.isEmpty()) {
                            sb.append(st.pop());
                        }
                        sb.append(' ');
                    } else {
                        st.push(c);
                    }
                }
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        System.out.println(sb);
    }
}