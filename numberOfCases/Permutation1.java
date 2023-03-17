package numberOfCases;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation1 {
    static int N, R, totalCnt;
    static int[] numbers;       // 선택한 숫자
    static boolean[] isSelected;    // 카드 선택 여부

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 4
        R = sc.nextInt();   // 3
        numbers = new int[R];   // 4개중 3개만 뽑을 거니까
        isSelected = new boolean[N + 1];    // 0번 인덱스는 사용안할거임

        perm(0);
    }

    private static void perm(int cnt) {     // 현재 뽑아야하는 카드 위치
        if (cnt == R) {     // 기저 조건
            totalCnt ++;
            System.out.println(Arrays.toString(numbers));       // 선택한 카드
            System.out.println(Arrays.toString(isSelected));
            return;
        }

        for (int card = 1; card <= N; card++) {
            if(isSelected[card]) continue;
            numbers[cnt] = card;       // cnt 번째 카드는 card 숫자 선택
            isSelected[card] = true;
            perm(cnt + 1);
            isSelected[card] = false;   // 다음 step 을 위해 false 로 초기화
        }
    }
}
