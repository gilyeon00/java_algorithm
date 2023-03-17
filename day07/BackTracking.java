package day07;

import java.util.Arrays;
import java.util.Scanner;

// 1부터 100까지 정수 중 5개를 뽑아 합이 150이 되는 경우의 수를 출력하세요.
public class BackTracking {

    static int N = 100, M = 5, target = 150;
    static int[] arr = new int[N];
    static int[] select = new int[M]; // 선택한 숫자

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }

        backtracking(0, 0, 0);
    }

    private static void backtracking(int cnt, int startIndex, int sum) {
        if (cnt == M) {
            if (sum == target) System.out.println(Arrays.toString(select));
            return;
        }
        for (int i = startIndex; i < N; i++) {
            select[cnt] = arr[i];

            if (sum + select[cnt] <= target) { // 누적 합이 target 이하일 때만 다음 숫자 선택 (백트래킹)
                backtracking(cnt+1, i+1, sum+select[cnt]);
            }
        }
    }

}