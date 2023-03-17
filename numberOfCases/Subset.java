package numberOfCases;

import java.util.Scanner;

public class Subset {

    static int N, totalCnt;
    static int[] arr;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        isSelected = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        subset(0);

    }

    private static void subset(int cnt) {   // 몇번째 값을 뽑고 있는지
        if (cnt == N) {
            totalCnt++;
            for (int i = 0; i < N; i++) {   // 한 개의 부분집합 안에 있는 요소 출력
                if (isSelected[i])  System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }
        // cnt번째 값을 뽑은 경우
        isSelected[cnt] = true;
        subset(cnt + 1);

        // cnt번째 값을 안뽑는 경우
        isSelected[cnt] = false;
        subset(cnt+1);

    }
}
