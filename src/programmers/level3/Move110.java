package programmers.level3;

//110옮기기
public class Move110 {
    public String[] solution(String[] s) {
        String[] result = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            String str = s[i];
            StringBuilder sb = new StringBuilder();
            int cnt = 0;

            for (int j = 0; j < str.length(); j++) {
                sb.append(str.charAt(j));
                int len = sb.length();
                if (len >= 3) {
                    if (sb.charAt(len-3) == '1' && sb.charAt(len-2) == '1' && sb.charAt(len-1) == '0') {
                        sb.delete(len-3, len);
                        cnt++;
                    }
                }
            }

            String plusStr = "110".repeat(cnt);

            int idx = -1;
            for (int j = sb.length() - 1; j >= 0; j--) {
                if (sb.charAt(j) == '0') {
                    idx = j;
                    break;
                }
            }

            if (idx < 0) {
                str = plusStr + sb.toString();
            } else {
                str = sb.substring(0, idx + 1) + plusStr + sb.substring(idx+1);
            }

            result[i] = str;
        }

        return result;
    }
}
