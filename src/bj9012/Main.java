package bj9012;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static String[] list;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        list = new String[N];

        for (int i = 0; i < list.length; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = st.nextToken();
        }

        for (int i = 0; i < list.length; i++) {
            checkVPS(list[i]);
        }
        bw.flush();
        bw.close();
    }

    public static void checkVPS(String set) throws IOException {
        Stack stack = new Stack();
        char[] charSet = set.toCharArray();
        int i;
        for (i = 0; i < charSet.length; i++) {
            if (charSet[i] == '(') {
                stack.push(charSet[i]);
            } else if (stack.empty()) {
                break;
            } else {
                stack.pop();
            }
        }
        if (i < charSet.length || !stack.empty()){
            bw.write("NO\n");
        }
        else {
            bw.write("YES\n");
        }
    }
}
