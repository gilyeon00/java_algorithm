package day05;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class BOJ15650_comb {
    static int N, M, totalCnt;
    static int[] numbers;
    static int[] inputArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        totalCnt = 0;
        numbers = new int[M];
        inputArr = new int[N];
        for (int i = 0; i < N; i++) {
            inputArr[i] = i+1;
        }

        comb(0,0);
    }

    private static void comb(int cnt, int startIdx) {
        if (cnt == M) {
            totalCnt++;
            for (int i : numbers) {
                System.out.println(i);
            }
            return;
        }
        for (int i = startIdx; i < N; i++) {
            numbers[cnt] = inputArr[i];
            comb(cnt + 1, i + 1);
        }
    }
}
