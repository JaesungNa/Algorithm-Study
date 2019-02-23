package bj2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #2293 : 동전 1
 * 알고리즘 분류 : Dynamic Programming
 *
 * @author jaesungna
 */
public class Main {
    private static int[] coins;
    private static int N;
    private static int K;
    private static int[] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[101];
        cache = new int[10001];

        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            coins[i]=Integer.parseInt(st.nextToken());
        }
        cache[0]=1;
        System.out.println(findCombination());
    }

    /**
     * findCombination:
     * - cache의 각 자리에는 각 동전으로 만들수 있는 조합의 경우의 수가 담김
     * - 다음 동전 가치가 나타났을때 해당 동전을 뺀 나머지의 위치에 가서 해당 위치의 값과 더해줌
     * - 이는 해당 위치의 값에서 이미 해당 동전의 조합으로 만들수 있는 경우의 수를 이미 구했기떄문에 가능함
     *
     * @return
     */
    public static int findCombination(){
        for(int i=0;i<N;i++){
            for(int j=0; j<=K;j++){
                if(j>=coins[i]){
                    cache[j]+= cache[j-coins[i]];
                }
            }
        }
        return cache[K];
    }
}
