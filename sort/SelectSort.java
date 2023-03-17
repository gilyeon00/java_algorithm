package sort;

import java.util.Arrays;

public class SelectSort {
    static int[] arr = {7,2,8,1,6,3,5};

    public static void main(String[] args) {
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int minIdx = i;
            for(int j=i+1; j<arr.length; j++){     // 내꺼 이후의 최솟값 찾기
                if(arr[minIdx] > arr[j]) minIdx = j;
            }
            swap(arr, minIdx, i);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
