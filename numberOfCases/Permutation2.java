package numberOfCases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Permutation2 {
    static int N, R, totalCnt;
    static int[] numbers, arr;
    static Boolean[] isSelected;

    private static void perm(int cnt){
        if (R == cnt) {
            totalCnt ++;
            System.out.println(Arrays.toString(numbers));
            System.out.println(Arrays.toString(isSelected));
            return;
        }
        for (int cardIdx = 0; cardIdx < N; cardIdx++) {
            if(isSelected[cardIdx]) continue;
            int card = arr[cardIdx];

            numbers[cnt] = card;
            isSelected[cardIdx] = true;
            perm(cnt + 1);
            isSelected[cardIdx] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // N개 정수
        R = Integer.parseInt(st.nextToken());    // R개 선택
        numbers = new int[R];
        arr = new int[N+1];
        isSelected = new Boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);
    }
}
