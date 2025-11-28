package programmers.level3;

public class steppingStones {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (!check(stones, k, mid)) {
                right = mid -1;
            } else {
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }

        return answer;
    }

    public boolean check(int[]stones, int k, int now) {
        int skip = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] < now) {
                skip++;
            } else {
                skip = 0;
            }
            if (skip >= k) {
                return false;
            }
        }
        return true;
    }
}
