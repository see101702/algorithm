package programmers.level2;

// 타겟넘버
public class targetNumber {
    static int ans;
    public int solution(int[] numbers, int target) {
        ans = 0;

        dfs(0, 0, numbers, target);

        return ans;
    }

    public static void dfs(int sum, int idx, int[] numbers, int target) {
        if (idx == numbers.length) {
            if (sum == target) ans++;
            return;
        }

        dfs(sum+numbers[idx], idx+1, numbers, target);
        dfs(sum-numbers[idx], idx+1, numbers, target);
    }
}
