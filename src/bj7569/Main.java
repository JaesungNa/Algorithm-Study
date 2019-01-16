package bj7569;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 알고리즘
 * #7569 토마토
 * 알고리즘 분류 : BFS 활용(3차원)
 *
 * @author jaesungna
 */
public class Main {
    private static int[][][] MAP;
    private static int[] dh = {0, 0, 0, 0, 1, -1};
    private static int[] dw = {0, 0, 1, -1, 0, 0};
    private static int[] dl = {1, -1, 0, 0, 0, 0};
    private static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); //width
        int N = sc.nextInt(); //length
        int H = sc.nextInt(); //height
        MAP = new int[H][N][M];

        int MAX = 0;

        for (int h = 0; h < H; h++) {
            for (int l = 0; l < N; l++) {
                for (int w = 0; w < M; w++) {
                    MAP[h][l][w] = sc.nextInt();
                    if (MAP[h][l][w] == 0) {
                        cnt++;
                    }
                }
            }
        }

        for (int h = 0; h < H; h++) {
            for (int l = 0; l < N; l++) {
                for (int w = 0; w < M; w++) {
                    if (MAP[h][l][w] == 1) {
                        Position pos = new Position(h, l, w);
                        int tempMax = bfs(M, N, H, pos);
                        if (cnt > 0) {
                            MAX = -1;
                        } else if (MAX < tempMax) {
                            MAX = tempMax;
                        }
                    }
                }
            }
        }
        System.out.println(MAX);
    }

    public static int bfs(int M, int N, int H, Position pos) {
        int tempMax = 0;
        int[][][] dist = new int[H][N][M];
        Queue<Position> queue = new LinkedList<>();
        queue.add(pos);
        while (!queue.isEmpty()) {
            Position tempPos = queue.poll();
            int h = tempPos.h;
            int w = tempPos.w;
            int l = tempPos.l;
            MAP[h][l][w] = 1;
            for (int cur = 0; cur < 6; cur++) {
                int nh = dh[cur] + h;
                int nw = dw[cur] + w;
                int nl = dl[cur] + l;
                if (nh >= 0 && nw >= 0 && nl >= 0 && nh < H && nl < N && nw < M) {
                    if (MAP[nh][nl][nw] == 0) {
                        cnt--;
                        Position newPos = new Position(nh, nl, nw);
                        queue.add(newPos);
                        MAP[nh][nl][nw] = 1;
                        dist[nh][nl][nw] = dist[h][l][w] + 1;
                        if (tempMax < dist[nh][nl][nw]) {
                            tempMax = dist[nh][nl][nw];
                        }
                    }
                }
            }
        }
        return tempMax;
    }
}

class Position {
    int w;
    int l;
    int h;

    public Position(int h, int l, int w) {
        this.w = w;
        this.l = l;
        this.h = h;
    }
}
