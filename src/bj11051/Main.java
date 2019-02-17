package bj11051;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #11051 이항계수 2
 * 알고리즘 분류 :
 *
 * @author jaesungna
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = binoCoef_1(N, K);
        System.out.print(result);
    }

    /**
     * binoCoef_!(n, k) : 점화식을 이용한 이항계수 계산 재귀함수
     * result : 시간초과
     *
     * @param n : 전체 갯수
     * @param k : k 개를 뽑음
     * @return : 점화식
     */
    public static int binoCoef_1(int n, int k) {
        // 1.
        if (k == 0 || n == k) {
            return 1;
        }

        // 2.
        return (binoCoef_1(n - 1, k) + binoCoef_1(n - 1, k - 1))%10007;
    }

    /**
     * binoCoef_2(n, k) : DP 와 점화식을 이용한 이항계수 계산 재귀함수
     * result : correct
     *
     * @param n : 전체 갯수
     * @param k : k 개를 뽑음
     * @return : 결과값
     */
    public static int binoCoef_2(int n, int k) {
        // 1.
        int[][] cache = new int[n + 1][k + 1];

        // 2.
        for (int i = 0; i < n + 1; i++) {
            cache[i][0] = 1;
        }
        for (int i = 0; i < k + 1; i++) {
            cache[i][i] = 1;
        }

        // 3.
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                cache[i][j] = (cache[i - 1][j - 1] + cache[i - 1][j])%10007;
            }
        }

        return cache[n][k];
    }
}
