package programmers.level3;

//자물쇠와 열쇠
public class keyAndLock {
    static int[][] arr;
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int k = key.length;
        arr = new int[n + 2*k - 2][n + 2*k - 2];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i+k-1][j+k-1] = lock[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            key = rotate(key);

            for (int s = 0; s <= arr.length - k; s++) {
                for (int t = 0; t <= arr.length - k; t++) {

                    boolean flag = true;

                    for (int m = 0; m < k; m++) {
                        for (int l = 0; l < k; l++) {
                            arr[m+s][l+t] += key[m][l];
                        }
                    }

                    out: for (int m = 0; m < n; m++) {
                        for (int l = 0; l < n; l++) {
                            if (arr[m+k-1][l+k-1] != 1) {
                                flag = false;
                                break out;
                            }
                        }
                    }

                    if (!flag) {
                        for (int m = 0; m < k; m++) {
                            for (int l = 0; l < k; l++) {
                                arr[m+s][l+t] -= key[m][l];
                            }
                        }
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public int[][] rotate(int[][] key) {

        int[][] r = new int[key.length][key.length];

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                r[i][j] = key[j][key.length - 1 - i];
            }
        }

        return r;
    }
}
