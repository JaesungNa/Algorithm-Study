package bj2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #2579 계단 오르기
 * 알고리즘 분류 : Dynamic Programming
 * <p>
 * 접근 방법:
 * 1. 조건을 분석하여 점화식을 구한다
 * 2. 점화식의 최소 조건을 cache에 저장한다
 * 3. 점화식을 이용해 반복문을 돌린다.
 *
 * @author jaesungna
 */
public class Main {
    private static int[] steps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        steps = new int[N];
        int result = findMax(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            steps[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findMax(N));
    }

    public static int findMax(int N) {
        int[] cache = new int[N];
        if (N > 0) {
            cache[0] = steps[0];
        }
        if (N > 1) {
            cache[1] = Math.max(steps[1], steps[0] + steps[1]);
        }
        if (N > 2) {
            cache[2] = Math.max(steps[2] + steps[1], steps[2]+cache[0]);
            for (int i = 3; i < N; i++) {
                cache[i] = Math.max(steps[i] + steps[i - 1] + cache[i - 3], steps[i] + cache[i - 2]);
            }
        }
        return cache[N - 1];
    }
}
