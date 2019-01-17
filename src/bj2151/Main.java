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
 *
 * @author jaesungna
 */

public class Main {
    private static String[][] MAP;
    private static int cnt = 0;
    private static int[] dl = {1, 0, 0};//직진, 좌, 와
    private static int[] dw = {0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        MAP = new String[N][N];

        for (int l = 0; l < N; l++) {
            st = new StringTokenizer(br.readLine());
            MAP[l] = st.nextToken().split("");
        }
        outer_loop:
        for (int l = 0; l < MAP.length; l++) {
            for (int w = 0; w < MAP[l].length; w++) {
                if (MAP[l][w].equals("#")) {
                    bfs(new Position(w, l));
                    break outer_loop;
                }
            }
        }

    }

    /**
     * bfs
     * <p>
     * "!"를 만났을때 조치 경우의 수
     * 1. 거울을 설치 안할때
     * 2. 거울을 "\"로 설치
     * 3. 거울을 "/"로 설치
     */
    public static void bfs(Position pos) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(pos);
        while (!queue.isEmpty()) {
            Position cpos = queue.poll();
            int l = cpos.l;
            int w = cpos.w;
            int nw;
            int nl;
            if (MAP[l][w].equals("/")) {
                nw = dw[1] + w;
                nl = dl[1] + l;
            }
            else if (MAP[l][w].equals("\\")) {
                nw = dw[0] + w;
                nl = dl[0] + l;
            }
            else{
                nw = dw[0] + w;
                nl = dl[0] + l;
            }


            if (MAP[l][w].equals("*")) {
                continue;
            } else if (MAP[l][w].equals(".")) {
                //go straight
                queue.add(new Position(nw, nl));
                //visited = true
            } else if (MAP[l][w].equals("!")) {
                //set mirror
                MAP[l][w] = "/";

            } else if (MAP[l][w].equals("#")) {
                //reached the other door
            }

        }
    }
    public static boolean isInsideMap(int nw, int nl){
        if (nw >= 0 && nw < MAP[0].length && nl >= 0 && nl < MAP.length) {
            return true;
        }
        else{
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

    public Position(int w, int l) {
        this.w = w;
        this.l = l;
    }
}

