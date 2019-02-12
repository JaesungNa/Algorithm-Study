package bj1181;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #1181 단어정렬
 * 알고리즘 분류 : 합병정렬
 *
 * @author jaesungna
 */

public class Main {
    private static String[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        list = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = st.nextToken();
        }
        br.close();

        mergeSort(0, list.length - 1);
        print();
    }

    public static void mergeSort(int p, int q) {
        if ((q - p) < 1) {
            return;
        }
        int mid = (p + q) / 2;

        mergeSort(p, mid);
        mergeSort(mid + 1, q);
        merge(p, q, mid);
    }

    public static void merge(int p, int q, int mid) {
        int i = p;
        int j = mid + 1;
        int k = 0;
        String[] temp = new String[q + 1];

        while (i < mid + 1 && j < q + 1) {
            if (list[i].length() < list[j].length()) {
                temp[k++] = list[i++];
            } else if (list[i].length() > list[j].length()) {
                temp[k++] = list[j++];
            } else {
                int u = 0;
                while (u < list[i].length() && (toAschii(list[i], u) == toAschii(list[j], u))) {
                    u++;
                }
                if(u==list[i].length()){
                    temp[k++] = list[i++];
                    temp[k++] = list[j++];
                }
                else if (toAschii(list[i], u) < toAschii(list[j], u)) {
                    temp[k++] = list[i++];
                } else {
                    temp[k++] = list[j++];
                }
            }
        }
        while (i < mid + 1) {
            temp[k++] = list[i++];
        }
        while (j < q + 1) {
            temp[k++] = list[j++];
        }

        int tcnt = 0;
        for (int cnt = p; cnt < q + 1; cnt++) {
            list[cnt] = temp[tcnt++];
        }
    }

    public static int toAschii(String word, int index) {
        return (int) word.charAt(index);
    }

    public static void print() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= list.length; i++) {
            if(i==list.length){
                bw.write(list[i-1] + "\n");
                break;
            }
            if (list[i].equals(list[i - 1])) {
                continue;
            }
            else{
                bw.write(list[i-1] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
