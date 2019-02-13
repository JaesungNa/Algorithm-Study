package bj1158;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #1158 조세퍼스 문제
 * 알고리즘 분류 : circular queue
 *
 * @author jaesungna
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        int val = -1;
        bw.write("<");
        while(!queue.isEmpty()){
            for (int j = 1; j < R; j++) {
                val = queue.poll();
                queue.add(val);
            }
            bw.write(queue.poll()+"");
            if(!queue.isEmpty()){
                bw.write(", ");
            }
        }
        bw.write(">");
        bw.flush();
        bw.close();
    }
}
