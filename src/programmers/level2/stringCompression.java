package programmers.level2;

//문자열압축
public class stringCompression {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            String prev = s.substring(0, i);

            for (int j = i; j < s.length(); j+=i) {
                int endIdx = Math.min(s.length(), j+i);

                if (s.substring(j, endIdx).equals(prev)) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        sb.append(cnt);
                    }
                    sb.append(prev);
                    prev = s.substring(j, endIdx);
                    cnt = 1;
                }
            }
            if (cnt > 1) {
                sb.append(cnt);
            }
            sb.append(prev);
            answer = Math.min(answer, sb.toString().length());
        }

        return answer;
    }
}
