package programmers.level2;

import java.util.*;

// 지게차와 크레인
public class forkliftAndCrane {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        int ans = n * m;
        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = storage[i].charAt(j);
            }
        }

        for (int i = 0; i < requests.length; i++) {
            String req = requests[i];
            char[][] newArr = new char[n][m];

            for (int s = 0; s < n; s++) {
                for (int t = 0; t < m; t++) {
                    newArr[s][t] = arr[s][t];
                }
            }

            if (req.length() == 1) {
                for (int s = 0; s < n; s++) {
                    for (int t = 0; t < m; t++) {
                        if (arr[s][t] != req.charAt(0)) continue;

                        boolean[][] outside = new boolean[n][m];
                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[] {s, t});
                        outside[s][t] = true;
                        boolean flag = false;

                        while (!q.isEmpty()) {
                            int[] now = q.poll();

                            if (now[0] < 0 || now[0] >= n || now[1] < 0 || now[1] >= m) {
                                flag = true;
                                break;
                            }

                            for (int k = 0; k < 4; k++) {
                                int newX = now[0] + dx[k];
                                int newY = now[1] + dy[k];

                                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                                    q.add(new int[] {newX, newY});
                                } else {
                                    if (!outside[newX][newY] && arr[newX][newY] == '-') {
                                        q.add(new int[] {newX, newY});
                                        outside[newX][newY] = true;
                                    }
                                }
                            }
                        }
                        if (flag) {
                            newArr[s][t] = '-';
                            ans--;
                        }
                    }
                }
            } else {
                for (int s = 0; s < n; s++) {
                    for (int t = 0; t < m; t++) {
                        if (arr[s][t] != req.charAt(0)) continue;

                        newArr[s][t] = '-';
                        ans--;
                    }
                }
            }

            for (int s = 0; s < n; s++) {
                for (int t = 0; t < m; t++) {
                    arr[s][t] = newArr[s][t];
                }
            }
        }

        return ans;
    }
}
