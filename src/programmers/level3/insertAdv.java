package programmers.level3;

// 광고삽입
public class insertAdv {
    public String solution(String play_time, String adv_time, String[] logs) {
        int totalTime = makeS(play_time);
        long[] arr = new long[totalTime+1];
        int adv = makeS(adv_time);

        for (int i = 0; i < logs.length; i++) {
            int start = makeS(logs[i].substring(0,8));
            int end = makeS(logs[i].substring(9));

            arr[start] += 1;
            arr[end] -= 1;
        }

        for (int i = 1; i <= totalTime; i++) {
            arr[i] += arr[i-1];
        }

        for (int i = 1; i <= totalTime; i++) {
            arr[i] += arr[i-1];
        }

        int ans_start = 0;
        long max = arr[adv-1];

        for (int i = adv; i <= totalTime; i++) {
            long cur = arr[i] - arr[i-adv];

            if(cur > max) {
                max = cur;
                ans_start = i - adv + 1;
            }
        }

        String result = makeStr(ans_start);
        return result;
    }
    public static int makeS(String str) {
        int h = Integer.parseInt(str.substring(0,2));
        int m = Integer.parseInt(str.substring(3,5));
        int s = Integer.parseInt(str.substring(6,8));

        int ans = h * 3600 + m * 60 + s;

        return ans;
    }
    public static String makeStr(int time) {
        int h = time / 3600;
        int m = (time % 3600) / 60;
        int s = (time % 3600) % 60;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", h));
        sb.append(":");
        sb.append(String.format("%02d", m));
        sb.append(":");
        sb.append(String.format("%02d", s));

        return sb.toString();
    }
}
