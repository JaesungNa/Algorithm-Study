package bj1057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #1057 토너먼트
 * 알고리즘 분류 :
 *
 * @author jaesungna
 */

public class Main {
    private static int K;
    private static int I;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        I = Integer.parseInt(st.nextToken());
        int count = 0;
        while (K != I) {
            K = K / 2 + K % 2;
            I = I / 2 + I % 2;
            count++;
        }
        System.out.println(count);
    }


}
