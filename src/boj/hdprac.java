package boj;

import java.util.*;

// 현대오토에버 신입 코테
public class hdprac {

    static List<Integer>[] graph;
    static int[] people;
    static int[] parent;
    static int max = 0;

    public static void main(String[] args) {

        int n = 6;

        int[][] paths = {
                {1,2},
                {2,4},
                {1,3},
                {3,5},
                {3,6}
        };

        int[][] records = {
                {6,2},
                {5,3}
        };

        solution(n, paths, records);
    }

    static void solution(int n, int[][] paths, int[][] records){
        graph = new ArrayList[n+1];
        parent = new int[n+1];
        people = new int[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < paths.length; i++) {
            graph[paths[i][0]].add(paths[i][1]);
            graph[paths[i][1]].add(paths[i][0]);
        }

        for (int i = 0; i < records.length; i++) {
            people[records[i][0]] += records[i][1];
        }

        setParent(1, 0);
        dfs(1);

        System.out.println(max);
    }
    public static void setParent(int cur, int par){
        parent[cur] = par;

        List<Integer> li = graph[cur];

        for (int el : li) {
            if (el == par) continue;
            setParent(el, cur);
        }
    }
    public static int dfs(int cur){
        int sum = people[cur];

        List<Integer> li = graph[cur];

        for (int el : li) {
            if (el == parent[cur]) continue;
            int childSum = dfs(el);
            sum += childSum;
            max = Math.max(max, childSum);
        }

        return sum;
    }
}


