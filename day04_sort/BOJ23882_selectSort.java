package day04_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ23882_selectSort {
    private static  int k1=-1, k2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] numArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        selectSort(numArr, k);
        System.out.println(numArr);

    }

    private static void selectSort(int[] numArr, int k) {
        int cnt = 0;
        // numArr에서 가장 큰 수인 numArr[idx]를 찾기
        for (int i = numArr.length - 1; i > 1; i--) {
            int max = Integer.MIN_VALUE;
            int idx = 0;
            for (int j = 0; j < numArr.length; j++) {
                if (max < numArr[j]) {
                    max = numArr[j];
                    idx = j; // 최댓값을 가지고 있는 index
                }
            }
            if (i != idx) {     // i가 최대가 아닐때
                swap(idx, numArr[i], numArr);
                if (++cnt == k) {
                    k1 = numArr[idx];
                    k2 = numArr[i];
                }
            }
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
