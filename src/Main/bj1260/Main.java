package bj1260;

import java.util.LinkedList;
import java.util.Queue;
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
    private static Queue<Integer> queue = new LinkedList<>(); //queue is used in bfs
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        adj = new int[N + 1][N + 1]; //index 1부터 시작
        isVisited = new boolean[N + 1];


        for (int i = 0; i < M; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();

            adj[row][col] = 1;
            adj[col][row] = 1;
        }

        initVisited();
        dfs(V);

        sb.append("\n");

        initVisited();
        bfs(V);
        System.out.println(sb);
    }

    /**
     * DFS
     *
     * @param v : first vertex to start with
     */
    public static void dfs(int v) {
        if (isVisited[v] == true) return;
        isVisited[v] = true;
        sb.append(v+" ");
        for (int i = 0; i < adj[v].length; i++) {
            if (isVisited[i] == false && adj[v][i] == 1) {
                dfs(i);
            }
        }
    }

    /**
     * BFS
     *
     * @param v : first vertex to start with
     */
    public static void bfs(int v) {
        queue.add(v);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            isVisited[temp] = true;
            sb.append(temp+" ");
            for (int i = 0; i < adj[temp].length; i++) {
                if (isVisited[i] == false && adj[temp][i] == 1) {
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }


    public static void initVisited() {
        for (int i = 0; i < N + 1; i++) {
            isVisited[i] = false;
        }
    }

}
