package bj2151;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #2151 거울설치
 * 알고리즘 분류 :
 * <p>
 * 접근방법:
 * 1. 한 정점에서 다음 정점으로 이동할때 어느 방향으로 이동해 왔는지 알고 있어야 함
 * 2. "!"를 만났을때 이동 방향성에 따라 다음 이동 방향성이 상하, 또는 좌우로 결정됨
 * 3. "!"를 만나더라도 거울을 안세우고 직진 해도 됨
 * 4. 방문 정점은 배열로 따로 관리하여 재방문하였을때, 거울 갯수가 더 적으면 대치하고 큐에 add
 *
 * @author jaesungna
 */

public class Main {
    private static String[][] MAP;
    private static int cnt = 0;
    private static int[] dl = {0, 0, -1, 1}; //좌우 상하
    private static int[] dw = {-1, 1, 0, 0};
    private static int[][][] visited; // visited[length][width][direction] = num of mirror


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        MAP = new String[N][N];
        visited = new int[N][N][4];

        for (int l = 0; l < N; l++) {
            st = new StringTokenizer(br.readLine());
            MAP[l] = st.nextToken().split("");
        }

        outer_loop:
        for (int l = 0; l < MAP.length; l++) {
            for (int w = 0; w < MAP[l].length; w++) {
                if (MAP[l][w].equals("#")) { // MAP을 순회하며 시작 정점 찾기
                    for (int d = 0; d < 4; d++) { // 시작정점의 다음 정점이 상하좌우 중 어디에 있는지 찾기 위함
                        int nw = w + dw[d];
                        int nl = l + dl[d];
                        if (isInsideMap(nw, nl) && !MAP[nl][nw].equals("*")) { //시작정점에서 햇빛이 어느 방향에서 들어오는지 확인하기 위함
                            bfs(new Position(w, l, d)); // '#' 큐에 추가 - 시작 정점
                            break outer_loop;
                        }
                    }
                }
            }
        }
    }

    /**
     * bfs
     *
     * 큐에서 poll()한 정점이 "!"일때 조치 방법 경우의 수
     * [1] 거울을 설치할 경우
     *     1. 빛이 상/하로 입사한 경우
     *         1-1. 좌측으로 반사
     *         1-2. 우측으로 반사
     *     2. 빛이 좌/우로 입사한 경우
     *         2-1. 상측으로 반사
     *         2-2. 하측으로 반사
     * [2] 거울을 설치 하지 않을 경우
     *     1. 빛이 상하좌우로 입사한 경우 정점의 방향성을 그대로 가져
     *
     */
    public static void bfs(Position pos) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(pos);
        while (!queue.isEmpty()) {

        }

    }

    public static boolean isInsideMap(int nw, int nl) {
        if (nw >= 0 && nw < MAP[0].length && nl >= 0 && nl < MAP.length) {
            return true;
        } else {
            return false;
        }
    }

    public static void printMAP() {
        for (int l = 0; l < MAP.length; l++) {
            for (int w = 0; w < MAP.length; w++) {
                System.out.print(MAP[l][w]);
            }
            System.out.println();
        }
    }
}

class Position {
    int w;
    int l;
    int dir;

    public Position(int w, int l, int dir) {
        this.w = w;
        this.l = l;
        this.dir = dir;
    }
}

