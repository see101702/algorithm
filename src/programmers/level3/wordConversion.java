package programmers.level3;

// 단어변환
public class wordConversion {
    static int res;
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        res = Integer.MAX_VALUE;
        dfs(0, visited, begin, target, words);

        if (res == Integer.MAX_VALUE) res = 0;

        return res;
    }

    public static void dfs(int cnt, boolean[] visited, String begin, String target, String[] words) {
        if (begin.equals(target)) {
            res = Math.min(res, cnt);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if(check(begin, words[i]) && !visited[i]) {
                visited[i] = true;
                dfs(cnt+1, visited, words[i], target, words);
                visited[i] = false;
            }
        }
    }

    public static boolean check(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }

        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }
}