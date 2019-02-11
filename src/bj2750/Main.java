package bj2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #2750 수 정렬하기
 * 알고리즘 분류 : 선택정렬/버블정렬/삽입정렬
 *
 * @author jaesungna
 */

public class Main {
    private static int[] ARRAY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        ARRAY = new int[count];
        for (int cnt = 0; cnt < count; cnt++) {
            int temp = Integer.parseInt((new StringTokenizer(br.readLine())).nextToken());
            ARRAY[cnt] = temp;
        }
        insertionSort();
        print();
    }

    public static void selectionSort() {
        for (int i = 0; i < ARRAY.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < ARRAY.length; j++) {
                if (ARRAY[j] < ARRAY[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }
    public static void selectSort(){
        for(int i=0;i<ARRAY.length;i++){
            int i_max=i;
            int max = arr[]
        }
    }

    public static void bubbleSort() {
        for (int i = ARRAY.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (ARRAY[j - 1] > ARRAY[j]) {
                    swap(j, j - 1);
                }
            }
        }
    }

    public static void insertionSort() {
        for (int i = 1; i < ARRAY.length; i++) {
            int curValue = ARRAY[i];
            int pos = i;
            while (pos > 0 && ARRAY[pos - 1] > curValue) {
                ARRAY[pos] = ARRAY[pos - 1];
                pos--;
            }
            ARRAY[pos] = curValue;
        }
    }

    public static void swap(int i, int maxIndex) {
        int temp = ARRAY[i];
        ARRAY[i] = ARRAY[maxIndex];
        ARRAY[maxIndex] = temp;
    }

    public static void print() {
        for (int i = 0; i < ARRAY.length; i++) {
            System.out.println(ARRAY[i]);
        }
    }
}
