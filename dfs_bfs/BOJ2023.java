package dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2023 {
    static int N;
    static ArrayList[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // N : 자리 수

        /*
            String 으로 연결
            소수 확인 (check 메서드)
         */

        dfs("2", 1);
//        dfs("3", 1);
//        dfs("5", 1);
//        dfs("7", 1);


        System.out.println(sb.toString());

        br.close();

    }

    private static void dfs(String str, int numLen) {
        if (numLen == N) {
            sb.append(str + "\n");
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if(check(Integer.parseInt(str + i))){
                str += i;
                numLen += 1;
                dfs(str+i, numLen);
            }
        }
    }

    private static boolean check(int num) {
        if (num == 1) return false;

        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }



}
