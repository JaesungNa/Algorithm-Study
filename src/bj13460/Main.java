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
 * 목표:
 *     1. 빨간 구슬을 구멍을 통해 뺴낼 수 있는 최소한의 움직임 수 출력
 *     2. 움직임이 10번 초과 일 경우 -1 출력
 *
 * 접근방법:
 *     1. 구슬이 움직이게 만들기 위해 동서남북으로 이동할수있는 dx, dy 배열을 만든다
 *     2. 구슬은 동시에 움직이기에 같은 dx, dy 인덱스를 이용한다.
 *     3. dfs를 활용하여 벽을 만날때까지- 그 중 최소일 경우를 찾기
 *         3-1. 파란공이 먼저 빠질 경우 실패
 *         3-2. 동시에 빠져도 실패
 *         3-3. 10번 초과로 걸리면 -1
 *         3-4.
 *
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
    public static void bfs(){

    }
}
class Position{
    int v;
    int h;
    int cnt;

    public Position(int v, int h, int cnt){
        this.v = v;
        this.h = h;
        this.cnt = cnt;
    }
}
