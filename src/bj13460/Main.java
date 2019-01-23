package bj13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #13460 구슬 탈출2
 * 알고리즘 분류 :
 * <p>
 * 접근방법:
 * <p>
 * started at 15:25
 * ended at
 *
 * @author jaesungna
 */
public class Main {
    private static char[][] MAP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N = vertical
        //M = horizontal
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        MAP = new char[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            MAP[n] = temp.toCharArray();
        }



    }
}
