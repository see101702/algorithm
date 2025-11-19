package programmers.level2;

public class joystick {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();

        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            int up = c - 'A';
            int down = 'Z' - c + 1;
            answer += Math.min(up, down);
        }

        int move = n - 1;

        for (int i = 0; i < n; i++) {
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, 2 * i + (n - next));
            move = Math.min(move, 2 * (n - next) + i);
        }

        answer += move;
        return answer;
    }
}
