package bj2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘
 * #2609 최대공약수와 최소공배수
 * 알고리즘 분류 :
 *
 * @author jaesungna
 */
public class Main {
    private static ArrayList<Integer> prime = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
//        findPrime(10000);
//        System.out.println(LCM(A, B, 0));
//        System.out.println(GCD(A, B, 0));
        System.out.println(gcd(A,B));
        System.out.println(A*B/gcd(A,B));
    }

    public static void findPrime(int n) {
        prime.add(2);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < prime.size(); j++) {
                if (i % prime.get(j) == 0) break;
                if (j + 1 == prime.size()) {
                    prime.add(i);
                }
            }
        }
    }

    public static int GCD(int a, int b, int nextPrime) {
        if(nextPrime>=prime.size()-1){
            return 1;
        }
        if (a % prime.get(nextPrime) == 0 && b % prime.get(nextPrime) == 0) {
            return prime.get(nextPrime) * GCD(a / prime.get(nextPrime), b / prime.get(nextPrime), nextPrime);
        } else {
            return 1 * GCD(a, b, ++nextPrime);
        }
    }

    public static int LCM(int a, int b, int nextPrime) {
        if(nextPrime>=prime.size()-1){
            return a*b;
        }
        if (a % prime.get(nextPrime) == 0 && b % prime.get(nextPrime) == 0) {
            return prime.get(nextPrime) * LCM(a / prime.get(nextPrime), b / prime.get(nextPrime), nextPrime);
        } else {
            return 1 * LCM(a, b, ++nextPrime);
        }
    }
    public static int gcd(int a, int b){
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}
