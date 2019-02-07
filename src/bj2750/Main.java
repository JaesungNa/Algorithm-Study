package bj2750;

import com.sun.tools.javac.code.Attribute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #2750 수 정렬하기
 * 알고리즘 분류 : 선택정렬
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
        selectionSort();
        print();
    }

    public static void selectionSort() {
        for (int i = 0; i < ARRAY.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < ARRAY.length; j++) {
                if (ARRAY[j]<ARRAY[minIndex]){
                    minIndex=j;
                }
            }
            swap(i, minIndex);
        }
    }
    public static void swap(int i, int maxIndex){
        int temp =  ARRAY[i];
        ARRAY[i]=ARRAY[maxIndex];
        ARRAY[maxIndex]=temp;
    }

    public static void print() {
        for (int i = 0; i < ARRAY.length; i++) {
            System.out.println(ARRAY[i]);
        }
    }
}
