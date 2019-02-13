package bj11050;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #11050 이항계수 1
 * 알고리즘 분류 : recursion
 *
 * @author jaesungna
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        bf.close();

        int result = factorial(N) / (factorial(K) * factorial(N - K));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return n;
        }
        return n * factorial(n - 1);
    }
}
