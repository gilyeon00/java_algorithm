package numberOfCases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kb1반_알고리즘2번_정길연 {
    static int N, M;
    static final int LIMIT = 3;
    static int[] number, inputArr;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 사용가능 숫자 개수
        M = Integer.parseInt(st.nextToken());   // 최대 숫자 합

        number = new int[LIMIT];
        inputArr = new int[N];

        String[] s =  br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(s[i]);
        }

        comb(0, 0);
        System.out.println(max);
    }

    private static void comb(int cnt, int startIdx) {
        int sum = 0;

        if (cnt == LIMIT) {
            for (int i : number)    sum += i;
            if(sum > max && sum <M) max = sum;
            return;
        }
        for (int i = startIdx; i < N; i++) {
            number[cnt] = inputArr[i];
            comb(cnt+1, i+1);
        }
    }
}
