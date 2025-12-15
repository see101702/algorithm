package programmers.level3;

public class chuseokTraffic {
    public int solution(String[] lines) {
        int n = lines.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            String str = lines[i];
            int endTime = makeS(str.split(" ")[1]);

            int intervalStart = endTime;
            int intervalEnd = endTime + 999;
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                String st = lines[j];
                int endT = makeS(st.split(" ")[1]);
                int t = (int)(Double.parseDouble(st.split(" ")[2].substring(0, st.split(" ")[2].length() -1)) * 1000);
                int startT = endT - t + 1;
                if (startT <= intervalEnd && endT >= intervalStart) cnt++;
            }

            max = Math.max(cnt, max);
        }

        return max;
    }
    public static int makeS(String str) {
        String[] strArr = str.split(":");
        int res = (Integer.parseInt(strArr[0])*3600 + Integer.parseInt(strArr[1])*60
                + Integer.parseInt(strArr[2].substring(0,2)))*1000
                + Integer.parseInt(strArr[2].substring(3));
        return res;
    }
}
