package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

//단속카메라
public class camera {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt((int[] o) -> o[1]));
        int temp = Integer.MIN_VALUE;
        int answer = 0;

        for (int i = 0; i < routes.length; i++) {
            if (routes[i][0] > temp) {
                answer++;
                temp = routes[i][1];
            }
        }

        return answer;
    }
}
