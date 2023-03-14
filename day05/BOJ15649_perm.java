package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15649_perm {
    static int N, M, totalCnt;
    static int[] results;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        results = new int[M];
        isVisited = new boolean[N+1];

        perm(0);
    }

    private static void perm(int cnt) {
        if (M == cnt) {
            totalCnt ++;
            for (int j : results) {
                System.out.print(j + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(isVisited[i]) continue;
            results[cnt] = i;
            isVisited[i] = true;
            perm(cnt + 1);
            isVisited[i] = false;
        }
    }
}
