package bj10989;

import java.io.*;
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

        int cnt = 0;
        int max = -1;

        while (cnt < N) {
            int curVal = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            if (max < curVal) {
                max = curVal;
            }
            cum[curVal] = ++cum[curVal];
            cnt++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i <= max; i++) {
            if (cum[i] != 0) {
                while (cum[i] > 0) {
                    bw.write(i+"\n");
                    cum[i]--;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
