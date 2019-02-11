package bj2751;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #2751 수 정렬하기2
 * 알고리즘 분류 : 합병정렬/힙정렬/퀵정렬
 *
 * @author jaesungna
 */

public class Main {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, arr.length-1);
        print();
    }

    public static void mergeSort(int p, int q) {
        if ((q-p) <1) {
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
        int[] temp = new int[(q-p)+1];
        while (i < mid + 1 && j < q+1) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

            }
        }
        while (i < mid + 1) {
            temp[k++] = arr[i++];
        }
        while (j < q+1) {
            temp[k++] = arr[j++];
        }

        int tcnt=0;
        for (int cnt = p; cnt < q+1; cnt++) {
            arr[cnt]=temp[tcnt++];
        }
    }

    public static void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
