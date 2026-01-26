package programmers.level3;

import java.util.*;

// 길 찾기 게임
public class wayfindingGame {
    static class Node {
        int x;
        int y;
        int idx;
        Node left, right;
        Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    static List<Integer> pre;
    static List<Integer> post;
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }
        Arrays.sort(arr, Comparator.comparingInt((Node a) -> a.y).reversed().thenComparingInt(a->a.x));
        Node root = arr[0];
        for (int i = 1; i < n; i++) {
            insert(root, arr[i]);
        }

        pre = new ArrayList<>();
        post = new ArrayList<>();

        preorder(root);
        postorder(root);

        int[][] result = new int[2][n];
        for (int i = 0; i < n; i++) {
            result[0][i] = pre.get(i);
            result[1][i] = post.get(i);
        }

        return result;
    }
    public static void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else insert(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    public static void preorder(Node node) {
        if (node == null) return;
        pre.add(node.idx);
        preorder(node.left);
        preorder(node.right);
    }
    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        post.add(node.idx);
    }
}
