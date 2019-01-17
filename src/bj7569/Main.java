package bj7569;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #7569 토마토
 * 알고리즘 분류 : BFS 활용(3차원)
 *
 * 설명
 *     1. 기존 bfs와 다른 점은 방문 정점을 저장하는 배열을 따로 관리 하지 않고, 입력받은 matrix에 직접 표기
 *     2. bfs를 시작해야 하는 정점이 동시에 발생되므로, 큐에 입력받은 정점중 시작해야하는 정점들을 입력 받을 때 미리 add 해놓고 시작
 *     3. 모든 미방문 정점을 방문할때 까지 몇일이 걸리는 지에 대한 알고리즘이기에 큐의 사이즈를 매 반복문 마다 새로 저장해두고, 해당 사이즈까지만 반복
 *     4. 큐의 사이즈를 저장 해둠으로써 미방문 정점을 모두 방문하는데 몇일이 걸리는지 구할 수 있음
 *
 * 결론
 *     1. 동시에 여러 정점에서 bfs를 실행해야한다면, 큐에 미리 삽입
 *     2. 미방문을 방문으로 만드는데 걸리는 시간을 구하려면, 매 반복마다 큐의 사이즈를 저장하여, 해당 사이즈만큼에 poll을 하여 진행
 *
 * 성능 비교
 *     1. scanner : mem(293740kb), time(1464ms)
 *     2. bufferReader : mem(123264kb), time(600ms)
 *
 * @author jaesungna
 */
public class Main {
    private static int[][][] MAP;
    private static int[] dh = {0, 0, 0, 0, 1, -1};
    private static int[] dw = {0, 0, 1, -1, 0, 0};
    private static int[] dl = {1, -1, 0, 0, 0, 0};
    private static Queue<Position> queue = new LinkedList<>();
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken()); //width
        int N = Integer.parseInt(st.nextToken()); //length
        int H = Integer.parseInt(st.nextToken()); //height
        MAP = new int[H][N][M];


        int minDays = 0;

        for (int h = 0; h < H; h++) {
            for (int l = 0; l < N; l++) {
                st = new StringTokenizer(bf.readLine());
                for (int w = 0; w < M; w++) {
                    MAP[h][l][w] = Integer.parseInt(st.nextToken());
                    if (MAP[h][l][w] == 0) {
                        cnt++;
                    } else if (MAP[h][l][w] == 1) {
                        Position pos = new Position(h, l, w);
                        queue.add(pos);
                        MAP[h][l][w] = 1;
                    }
                }
            }
        }
        minDays = bfs(M, N, H);
        if(cnt>0){
            minDays=-1;
        }
        System.out.println(minDays);
    }

    public static int bfs(int M, int N, int H) {
        int days = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;
            for (int i = 0; i < size; i++) {
                Position tempPos = queue.poll();
                int h = tempPos.h;
                int w = tempPos.w;
                int l = tempPos.l;
                for (int cur = 0; cur < 6; cur++) {
                    int nh = dh[cur] + h;
                    int nw = dw[cur] + w;
                    int nl = dl[cur] + l;
                    if (nh >= 0 && nw >= 0 && nl >= 0 && nh < H && nl < N && nw < M) {
                        if (MAP[nh][nl][nw] == 0) {
                            cnt--;
                            Position newPos = new Position(nh, nl, nw);
                            queue.add(newPos);
                            MAP[nh][nl][nw] = 1;
                        }
                    }
                }
            }
        }
        return days;
    }
}

class Position {
    int w;
    int l;
    int h;

    public Position(int h, int l, int w) {
        this.w = w;
        this.l = l;
        this.h = h;
    }
}
