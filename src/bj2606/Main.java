package bj2606;
/**
 * 백준 알고리즘
 * #2606 바이러스
 * 알고리즘 분류 : BFS 기본
 *
 * 설명
 *     1. 한 정점에서 시작되어 모든 연결된 정점이 몇개인지 구하는 알고리즘
 *     2. 따라서 미방문 정점을 방문할때마다 count를 증가 시켜줌
 *
 * @author jaesungna
 */

import java.util.LinkedList;
import java.util.Queue;
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
        spreadVirus(1);

        System.out.println(maxContamination);
    }


    /**
     * To find the maximum number of computer that is contaminated by computer 1(starting vertex)
     * BFS method used
     *
     * @param v : computer1(starting vertex)
     */
    private static void spreadVirus(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            isVisited[temp]=true;
            for(int i = 1; i<adj[temp].length;i++){
                if(isVisited[i]==false && adj[temp][i]==1){
                    queue.add(i);
                    isVisited[i]=true;
                    maxContamination++;
                }
            }
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
