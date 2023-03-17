package stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. n: 수의 개수, m: 나눌 수 입력받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int remainSum = 0;
        int[] sameRemainArr = new int[m];

        // 2. n개 수 입력받으면서, 누적 합을 m으로 나눈 나머지를 배열 sumArr에 저장
        // (sum[j] - sum[i]) % m = 0
        // sum[j]m - sum[i]m = 0
        // sum[i]m = sum[j]m
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            remainSum = (remainSum + Integer.parseInt(st.nextToken())) % m;
            sameRemainArr[remainSum]++;      // 나머지를 인덱스로 설정해, 같은 나머지 개수 카운팅
        }

        long answer = sameRemainArr[0];
        for (int i = 0; i < m; i++) {
            answer += (long) sameRemainArr[i] * (sameRemainArr[i] - 1) / 2;
        }

        System.out.println(answer);
    }
}
