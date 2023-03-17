package sort;

public class QuickSort {
    static int[] arr = {5, 7, 1, 4, 6, 2, 3, 9, 8};
    public static void main(String[] args) {
        int n = arr.length;
        int center = arr[0];
        quickSort(0, arr.length-1);
    }

    private static void quickSort(int left, int right){
        if (left >= right) return ;
        
        // pivot 기준으로 값을 나누고, 최종 pivot의 위치 반환
        int center = partition(left, right);

        // pivot의 왼쪽과 오른쪽 다시 정렬
        quickSort(left, center - 1);
        quickSort(center + 1, right);
    }

    // 배열에서 left부터 right까지 pivot을 기준으로 나누는 함수
    private static int partition(int left, int right) {
        int pivot = left++;     // 왼쪽을 pivot으로 설정

        while(left < right){
            while(left<right && arr[left] <= arr[pivot])  left++;
            while(left<right && arr[right]>= arr[pivot]) right--;

            if (left < right) swap(left,right);
        }

        // while 종료 후 항상 left == right
        if (arr[left] < arr[pivot]){
            swap(left, pivot);
            return left;
        }else {
            swap(left-1, pivot);
            return left-1;
        }
    }

    private static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
