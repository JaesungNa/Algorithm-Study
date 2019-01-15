package bj2606;
/**
 * 백준 알고리즘
 * #2606 바이러스
 * 알고리즘 분류 : DFS/BFS 기본
 *
 * @author jaesungna
 */

import java.util.Scanner;

public class Main {
    private static int numOfVertex; // number of vertex in given graph
    private static int numOfEdges; // number of edges in given graph
    private static int[][] adj; // adjacent matrix to store graph
    private static boolean[] isVisited; // to store visited vertex in graph

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numOfVertex = sc.nextInt();
        numOfEdges = sc.nextInt();
        adj = new int[numOfVertex + 1][numOfVertex + 1];
        isVisited = boolean[numOfVertex + 1];

        for(int i=0; i<numOfEdges; i++){
            int row = sc.nextInt();
            int col = sc.nextInt();
            adj[row][col]=1;
            adj[col][row]=1;
        }

        initVisited();

    }


    /**
     * initialsing isVisited array
     *
     */
    private static void initVisited() {
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }
    }
}
