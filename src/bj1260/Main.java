package bj1260;

import java.util.Scanner;

/**
 * 백준 알고리즘
 * #1260 DFS와 BFS
 * 알고리즘 분류 : DFS/BFS 기본
 *
 * @author jaesungna
 */

public class Main {
    private static int N; //Num of vertices
    private static int M; //Num of edges
    private static int V; //First Vertex to start with
    private static int[][] adj; //Adjacent array to store input data
    private static boolean[] isVisited; //check visited vertex

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        adj = new int[N + 1][M + 1]; //index 1부터 시작
        isVisited = new boolean[N + 1];
        initVisited();

        for (int i = 0; i < M; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();

            adj[row][col] = 1;
            adj[col][row] = 1;
        }
    }

    /**
     * DFS
     *
     * @param : first vertex to start with
     * @return : nothing
     */
    public static void dfs(int v){

    }

    /**
     * BFS
     *
     * @param : first vertex to start with
     * @return : nothing
     */
    public static void bfs(int v){

    }


    public static void initVisited() {
        for (int i = 0; i < N + 1; i++) {
            isVisited[i] = false;
        }
    }

    public static void printAdj() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}
