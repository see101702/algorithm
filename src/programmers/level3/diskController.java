package programmers.level3;

import java.util.*;

// 디스크 컨트롤러
public class diskController {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b)-> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a)->a[1]));

        int n = jobs.length;
        int idx = 0;
        int time = 0;
        int total = 0;
        while (idx < n || !pq.isEmpty()) {
            while (idx < n && jobs[idx][0] <= time) {
                pq.add(jobs[idx]);
                idx++;
            }

            if (!pq.isEmpty()) {
                int[] now = pq.poll();
                time += now[1];
                total = total + time - now[0];
            } else {
                time = jobs[idx][0];
            }
        }

        return total / n;
    }
}
