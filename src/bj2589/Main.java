package bj2589;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 알고리즘
 * #2589 보물섬
 * 알고리즘 분류 : BFS(최단 경로 찾기)
 *
 * @author jaesungna
 */
public class Main {
    private static String[][] MAP; // to store the given map
    private static boolean[][] isVisited; // to store visited location
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int minTime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        MAP = new String[row][col];
        isVisited = new boolean[row][col];

        sc.useDelimiter("");
        sc.next();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                MAP[i][j] = sc.next();
            }
            sc.next();
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Point curPos = new Point(i, j);
                bfs(curPos);
            }
        }
    }

    private static int bfs(Point pos) {
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

                if (nx > 0 && ny > 0 && isVisited[nx][ny] == false && MAP[nx][ny]=="L"){
                    Point nextPos = new Point(nx, ny);
                    queue.add(nextPos);
                    isVisited[nx][ny]=true;
                }
            }
        }
    }
}

public class Point {
    public static int posX;
    public static int posY;

    public Point(int x, int y) {
        posX = x;
        posY = y;
    }
}
