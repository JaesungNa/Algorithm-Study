package bj1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #1890 점프
 * 알고리즘 분류 : dynamic programming
 *
 * @author jaesungna
 */
public class Main {
    private static int N;
    private static int[][] MAP = new int[101][101];
    private static long[][] cache = new long[101][101]; // must be long since result is equal or less than 2^63-1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        findWay(0, 0);
        findway();
        System.out.println((int)cache[N - 1][N - 1]);
    }

    /**
     * recursion: timeout
     *
     * @param i
     * @param j
     */
//    public static void findWay(int i, int j) {
//        if (i > N - 1 || j > N - 1) {
//            return;
//        }
//        if(i == N - 1 && j == N - 1){
//            cache[i][j] += 1;
//            return;
//        }
//        findWay(i, j + MAP[i][j]);
//        findWay(i + MAP[i][j], j);
//    }
    public static void findway() {
        cache[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cache[i][j] == 0 || (i == N - 1 && j == N - 1)) {
                    continue;
                }
                int dist = MAP[i][j];
                int down = i + dist;
                int right = j + dist;
                if (down < N) {
                    cache[down][j] += cache[i][j];
                }
                if (right < N) {
                    cache[i][right] += cache[i][j];
                }
            }
        }
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
    }
}
