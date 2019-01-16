package bj7569;


import java.util.Scanner;

/**
 * 백준 알고리즘
 * #7569 토마토
 * 알고리즘 분류 :
 *
 * @author jaesungna
 */
public class Main {
    private static int[][][] MAP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); //width
        int N = sc.nextInt(); //length
        int H = sc.nextInt(); //height
        MAP = new int[H][N][M];

        for(int i=0; i<H;i++){
            for(int j=0; j<N;j++){
                for(int k=0; k<M;k++){
                    MAP[i][j][k]=sc.nextInt();
                }
            }
        }

    }
}
