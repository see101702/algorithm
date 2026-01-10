package boj;

//롯데이노베이트 코테
public class practice {

    public static long countPossibleArrays(int a, int b, String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n-1; i >= 0; i--) {
            long num = 0;
            for (int j = i; j < n; j++) {
                if (j > i && s.charAt(i) == '0') break;
                int temp = s.charAt(i) - '0';
                num = num * 10 + temp;

                if (num >= a && num <= b) {
                    dp[i] += dp[j+1];
                }
            }
        }

        return dp[0];
    }

    // 테스트용 main
    public static void main(String[] args) {
        int a = 1;
        int b = 1000;
        String s = "8057401";

        System.out.println(countPossibleArrays(a, b, s));
    }
}
