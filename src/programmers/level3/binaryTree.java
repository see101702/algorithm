package programmers.level3;

// 표현가능한 이진트리
public class binaryTree {
    public int[] solution(long[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            String str = Long.toBinaryString(num);

            int len = 1;

            while (len < str.length()) {
                len = len*2 + 1;
            }

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < len - str.length(); j++) {
                sb.append("0");
            }

            sb.append(str);

            result[i] = check(sb.toString()) ? 1 : 0;
        }

        return result;
    }

    public static boolean check(String strBin) {
        if (strBin.length() == 1) return true;
        int strLen = strBin.length();
        int mid = strLen / 2;
        char midChar = strBin.charAt(mid);
        String left = strBin.substring(0, mid);
        String right = strBin.substring(mid+1);

        if (midChar == '0') {
            if (left.contains("1")) {
                return false;
            }
            if (right.contains("1")) {
                return false;
            }
        }

        return check(left) && check(right);
    }
}
