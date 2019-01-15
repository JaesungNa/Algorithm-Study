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
    private static int maxContamination = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numOfVertex = sc.nextInt();
        numOfEdges = sc.nextInt();
        adj = new int[numOfVertex + 1][numOfVertex + 1];
        isVisited = new boolean[numOfVertex + 1];

        for(int i=0; i<numOfEdges; i++){
            int row = sc.nextInt();
            int col = sc.nextInt();
            adj[row][col]=1;
            adj[col][row]=1;
        }

        initVisited();
        spreadVirus(1, 0);

        System.out.println(maxContamination);
    }

    /**
     * To find the maximum number of computer that is contaminated by computer 1(starting vertex)
     * DFS method used
     *
     * @param v : computer1(starting vertex)
     */
    private static void spreadVirus(int v, int curContamination){
        if(isVisited[v]==true) return;
        isVisited[v]=true;
        curContamination++;
        for(int i=1; i<adj[v].length;i++){
            if(isVisited[i]==false && adj[v][i]==1) {
                spreadVirus(i, curContamination);
            }
        }
        //시작 정점에서 모든 리프정점까지의 길이 중 가장 높은 길이를 선택
        if (maxContamination < curContamination) {
            maxContamination = curContamination;
        }
    }

    /**
     * Initialising isVisited array
     *
     */
    private static void initVisited() {
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }
    }
}
