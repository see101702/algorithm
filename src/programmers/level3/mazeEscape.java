package programmers.level3;

// 미로 탈출 명령어
public class mazeEscape {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static int N, M, R, C, K;
    static String str;
    static boolean found = false;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        R = r;
        C = c;
        K = k;
        str = "";
        StringBuilder sb = new StringBuilder();

        int distance = Math.abs(x-r) + Math.abs(y-c);

        if (distance > k || (distance - k) % 2 != 0) {
            return "impossible";
        }

        dfs(x-1, y-1, sb);

        return str;
    }
    public static void dfs(int x, int y, StringBuilder sb) {

        if (found) return;

        if (sb.length() > K) return;

        int dist = Math.abs(x-R+1) + Math.abs(y-C+1);
        int remain = K - sb.length();
        if (dist > remain || (remain-dist) % 2 != 0) return;

        if (sb.length() == K && x == R-1 && y == C-1) {
            str = sb.toString();
            found = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newX >= N || newY < 0 || newY >= M) continue;

            char c = '-';

            if (i == 0) c = 'd';
            if (i == 1) c = 'l';
            if (i == 2) c = 'r';
            if (i == 3) c = 'u';

            StringBuilder newSb = new StringBuilder();
            newSb.append(sb.toString());
            newSb.append(c);

            dfs(newX, newY, newSb);
        }
    }
}
