package bj2589;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 알고리즘
 * #2589 보물섬
 * 알고리즘 분류 : BFS(최단 경로 찾기)
 *
 * 설명
 *     1. 주어진 matrix와 동안한 크기의 dist 배열을 사용
 *     2. dist 배열에 이전 위치로부터 이동할 경우 1씩 증가 시켜 저장. 한 위치의 bfs를 통해 얻어진 dist 원소들 중 최댓값을 반환
 *     3. matrix 내 시작가능한 모든 좌표에서 bfs를 돌려 각 위치에서 나온 최대 dist값 중 최댓값을 결과 값으로 갖음
 *
 * 결론
 *     1. bfs를 이용해 두 정점사이의 최단거리를 찾을 수 있음
 *
 * @author jaesungna
 */
public class Main {
    private static char[][] MAP; // to store the given map
    private static boolean[][] isVisited; // to store visited location
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int MaxDist = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        MAP = new char[row][col];
        isVisited = new boolean[row][col];
        sc.nextLine();

        for (int i = 0; i < row; i++) {
            String temp = sc.nextLine();
            MAP[i] = temp.toCharArray();
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (MAP[i][j]=='L') {
                    initVisited();
                    Point curPos = new Point(i, j);
                    int tempMax = bfs(curPos);
                    if (tempMax > MaxDist) {
                        MaxDist = tempMax;
                    }
                }
            }
        }
        System.out.println(MaxDist);
    }

    private static int bfs(Point pos) {
        int tempMax = 0;
        int[][] DIST = new int[MAP.length][MAP[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.add(pos);
        while (!queue.isEmpty()) {
            Point tempPos = queue.poll();
            int x = tempPos.posX;
            int y = tempPos.posY;

            isVisited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx >= 0 && ny >= 0 && nx < MAP.length && ny < MAP[0].length) {
                    if (isVisited[nx][ny] == false && MAP[nx][ny]=='L') {
                        Point nextPos = new Point(nx, ny);
                        queue.add(nextPos);
                        isVisited[nx][ny] = true;
                        DIST[nx][ny] = DIST[x][y] + 1;
                        if (tempMax < DIST[nx][ny]) {
                            tempMax = DIST[nx][ny];
                        }
                    }
                }
            }
        }
        return tempMax;
    }

    /**
     * Initialising isVisited array
     */
    private static void initVisited() {
        for (int i = 0; i < isVisited.length; i++) {
            for (int j = 0; j < isVisited[i].length; j++) {
                isVisited[i][j] = false;
            }
        }
    }
}

class Point {
    public int posX;
    public int posY;

    public Point(int x, int y) {
        posX = x;
        posY = y;
    }
}
