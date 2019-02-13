package bj1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #1021 회전하는 큐
 * 알고리즘 분류 : deque
 *
 * @author jaesungna
 */

public class Main {
    private static Deque<Integer> deque;
    private static int[] listM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        deque = new ArrayDeque<>(N);
        listM = new int[M];

        st = new StringTokenizer(br.readLine());
        int k = 0;
        while (st.hasMoreTokens()) {
            listM[k++] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        System.out.println(countMin());

    }

    public static int countMin() {
        ArrayList<Integer> tempList = new ArrayList<>();
        int curVal=0;
        int result=0;
        boolean isFound = false;
        int countFirst=-1;
        int countBack;
        for(int i=0; i<listM.length;i++){
            while(!isFound){
                curVal=deque.pollFirst();
                countFirst++;
                if(curVal==listM[i]){
                    isFound=true;
                }else{
                    tempList.add(curVal);
                }
            }
            countBack=deque.size()-countFirst+tempList.size()+1;
            if(countFirst<countBack){
                result+=countFirst;
            }else{
                result+=countBack;
            }
            for(int j=0;j<tempList.size();j++){
                deque.addLast(tempList.get(j));
            }
            isFound=false;
            countFirst=-1;
            countBack=-1;
            tempList.clear();
        }
        return result;
    }
}
