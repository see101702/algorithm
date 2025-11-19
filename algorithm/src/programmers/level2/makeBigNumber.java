package programmers.level2;

public class makeBigNumber {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < c) {
                sb.deleteCharAt(sb.length()-1);
                k--;
            }

            sb.append(c);
        }

        String answer = sb.toString();

        if (k > 0) {
            answer = answer.substring(0, answer.length() - k);
        }

        return answer;
    }
}
