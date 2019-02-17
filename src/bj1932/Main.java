package bj1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #1932 정수 삼각형
 * 알고리즘 분류 : Dynamic Programming
 *
 * @author jaesungna
 */

public class Main {
    private static int[][] triangle;
    private static int[] moveHor = {0, 1};
    private static int[] moveVer = {1, 1};
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        triangle = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(triangle[i], -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                triangle[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        findMax_2();
        System.out.println(result);
    }

    /**
     * findMax_1: recursion
     * result: 시간초과
     */
    public static void findMax_1(int i, int j, int curSum) {
        int[] nextPosLeft = {i + 1, j + 0};
        int[] nextPosRight = {i + 1, j + 1};
        if (!(i < triangle.length)) {
            if (result < curSum) {
                result = curSum;
            }
            return;
        }
        int total = triangle[i][j] + curSum;
        findMax_1(nextPosLeft[0], nextPosLeft[1], total);
        findMax_1(nextPosRight[0], nextPosRight[1], total);
    }

    /**
     * findMax_2: Dynamic Programming
     * result: success
     */
    public static void findMax_2() {
        int[][] cache = new int[triangle.length][triangle.length];
        for (int i = 0; i < triangle.length; i++) {
            int j = 0;
            while (j < triangle.length && triangle[i][j] != -1) {
                int[] rootLeft = {i - 1, j - 1};
                int[] rootRight = {i - 1, j};

                if (i == 0 && j == 0) {
                    cache[i][j] = triangle[i][j];
                }
                if (rootLeft[0] > -1 && rootLeft[1] > -1) {
                    int tempTotal = cache[rootLeft[0]][rootLeft[1]] + triangle[i][j];
                    if (cache[i][j] < tempTotal) {
                        cache[i][j] = tempTotal;
                    }
                }
                if (rootRight[0] > -1 && rootRight[1] > -1 && triangle[rootRight[0]][rootRight[1]] > -1) {
                    int tempTotal = cache[rootRight[0]][rootRight[1]] + triangle[i][j];
                    if (cache[i][j] < tempTotal) {
                        cache[i][j] = tempTotal;
                    }
                }
                j++;
            }
        }
        for (int i = 0; i < cache.length; i++) {
            if (result < cache[cache.length - 1][i]) {
                result = cache[cache.length - 1][i];
            }
        }
    }
}
