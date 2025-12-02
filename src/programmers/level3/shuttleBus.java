package programmers.level3;

import java.util.PriorityQueue;
//셔틀버스
public class shuttleBus {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < timetable.length; i++) {
            int min = Integer.parseInt(timetable[i].substring(0,2))*60 +
                    Integer.parseInt(timetable[i].substring(3,5));
            pq.add(min);
        }

        int startTime = 540;
        int lastTime = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            total = 0;

            while (!pq.isEmpty()) {
                int now = pq.peek();
                if (now <= startTime && total < m) {
                    pq.poll();
                    total++;
                    lastTime = now -1;
                } else {
                    break;
                }
            }
            startTime += t;
        }
        if (total < m) {
            lastTime = startTime - t;
        }

        int hour = lastTime / 60;
        int minute = lastTime % 60;

        String answer = String.format("%02d", hour) + ":" + String.format("%02d", minute);

        return answer;

    }
}
