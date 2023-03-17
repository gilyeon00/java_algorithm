package numberOfCases;

import java.util.Arrays;
import java.util.Scanner;

public class Combiantion {
    static int N, R, totalCnt;
    static int[] numbers, InputArr;  //선택한 숫자, 사용자입력배열


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        numbers = new int[R];
        InputArr = new int[N];

        for (int i = 0; i < N; i++) {
            InputArr[i] = sc.nextInt();
        }
        comb(0,0);
    }


    // cnt번째 카드 뽑기
    // startIdx부터 카드 뽑기
    private static void comb(int cnt, int startIdx) {
        if (cnt == R) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = startIdx; i < N; i++) {
            numbers[cnt] = InputArr[i];
            comb(cnt + 1, i + 1);
        }
    }
}
