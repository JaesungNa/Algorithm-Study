package bj9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #9251 LCS
 * 알고리즘 분류 : Dynamic Programming
 *
 * @author jaesungna
 */
public class Main {
    private static char[] list1;
    private static char[] list2;
    private static int[][] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list1 = st.nextToken().toCharArray();

        st = new StringTokenizer(br.readLine());
        list2 = st.nextToken().toCharArray();
        cache = new int[list1.length+1][list2.length+1];
//        LCS1(0, 0, 0);
        LCS2();
//        print();
        System.out.println(cache[list1.length][list2.length]);
    }
    public static void print(){
        for(int i=0; i<cache.length;i++){
            for(int j=0; j<cache[i].length;j++){
                System.out.print(cache[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void LCS1(int i, int j, int nextCount) {
        if (i >= cache.length - 1 || j >= cache[0].length) {
            return;
        }
        if (list1[i] == list2[j]) {
            if (nextCount < cache[i][j]) {
                return;
            }
            cache[i][j] = ++nextCount;
            LCS1(i + 1, j + 1, cache[i][j]);
        } else {
            LCS1(i + 1, j, nextCount);
            LCS1(i, j + 1, nextCount);
        }
    }

    public static void LCS2() {
        for(int i=1;i<=list1.length;i++){
            for(int j=1;j<=list2.length;j++){
                if(list1[i-1] == list2[j-1]){
                    cache[i][j]=cache[i-1][j-1]+1;
                }else{
                    cache[i][j]=Math.max(cache[i-1][j],cache[i][j-1]);
                }
            }
        }
    }
}
