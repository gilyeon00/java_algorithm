package graphGreedyBacktracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ15649 {

    static int N, M;
    static int[] arr;
    static int[] number;


    public static void main(String[] args) throws IOException {
        // 1부터 N까지 자연수 중 중복없이 M개 고른 수열 모두 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        number = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }

        comb(0, 0);
    }

    private static void comb(int cnt, int startIdx) {
        if (cnt == M) {
            for(int x : number) System.out.print(x+ " ");
            System.out.println();
            return;
        }
        for (int i = startIdx; i < N; i++) {
            number[cnt] = arr[i];
            comb(cnt+1, i+1);
        }
    }
}
