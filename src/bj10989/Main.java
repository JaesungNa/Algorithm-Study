package bj10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #10989 수 정렬하기3
 * 알고리즘 분류 : counting sort/radix sort
 *
 * @author jaesungna
 */
public class Main {
    private static int[] cum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = 10001;

        cum = new int[R];
        //Arrays.fill(cum, 0);

        int cnt = 0;
        int max = -1;
        //읽음과 동시에 누적시키기
        while (cnt < N) {
            int curVal = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            if (max < curVal) {
                max = curVal;
            }
            cum[curVal] = ++cum[curVal];
            cnt++;
        }
        //cum 원소 값들 배열 안에서 누적시키기
//        for (int i = 1; i <= max; i++) {
//            cum[i] = cum[i] + cum[i - 1];
//        }
        for (int i = 0; i <= max; i++) {
            if (cum[i] != 0) {
                while (cum[i] > 0) {
                    System.out.println(i);
                    cum[i]--;
                }
            }
        }
    }
}
