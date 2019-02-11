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
        bubbleSort();
        print();
    }

    /**
     * [min value is re-located at the start of array]
     * 1. 1st loop : scan from 0 to length-1
     * 2. minIndex : to store location of the minimum value in the array
     * 3. 2nd loop : in order to compare every single values in array to find the min value
     * 4. when compareTo-value(j) is smaller than compareFrom-value(minIndex), keep new value
     * 5. swap value after each search
     */
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

    /**
     * [searching range reduced from back since larger values is re-located at back of array]
     * 1. 1st loop: searching range set, range reduces from back
     * 2. 2nd loop: scan from 1 to length-1
     * 3. when compareTo-value(j) is smaller than compareFrom-value(j-1), swap value (always "j" must be larger)
     */
    public static void bubbleSort() {
        for (int i = ARRAY.length - 1; i > 0; i--) {
            for (int j = 1; j < ARRAY.length; j++) {
                if (ARRAY[j - 1] > ARRAY[j]) {
                    swap(j, j - 1);
                }
            }
        }
    }

    /**
     * [searching range gradually increase upto length-1]
     * 1. 1st loop: define search range(1 to length-1)
     * 2. store compareFrom-value, and position that the value-found to be re-located
     * 3. 2nd loop: search for right position within the range
     * 4. since curValue keeps the compareFrom-value, move the compareTo-value(pos-1) to CompareFrom-value(pos)
     * 5. if loop breaks position is found to insert curVal
     */
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
