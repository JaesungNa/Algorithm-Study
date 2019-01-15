package bj2589;

import java.util.Scanner;

/**
 * 백준 알고리즘
 * #2589 보물섬
 * 알고리즘 분류 : DFS/BFS 기본
 *
 * @author jaesungna
 */
public class Main {
    private static String[][] MAP; // to store the given map

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        MAP = new String[row][col];
        sc.useDelimiter("");
        sc.next();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                MAP[i][j] = sc.next();
            }
            sc.next();
        }

    }
}
