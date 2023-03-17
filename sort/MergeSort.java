package sort;

public class MergeSort {
    static int[] arr = {5,2,8,6,4,7,3,1};
    static int[] tmp = new int[arr.length];

    public static void main(String[] args) {
        mergeSort(0, arr.length-1);

    }

    private static void mergeSort(int left, int right){
        if (left >= right) return;
        int center = (left + right)/2;

        // Divide : center 기준으로 왼쪽, 오른쪽 배열 정렬
        mergeSort(left, center);
        mergeSort(center + 1, right);

        // Conquer : 왼쪽 오른쪽 배열을 하나의 배열로 병합
        // 임시 배열에 복사
        for (int i = left; i <= right; i++) {
            tmp[i] = arr[i];
        }

        int currIdx = left;
        int leftIdx = left;
        int rightIdx = center+1;

        while (leftIdx <= center && rightIdx <= right) {
            if (tmp[leftIdx] < tmp[rightIdx]) {
                arr[currIdx++] = tmp[leftIdx++];
            }else {
                arr[currIdx++] = tmp[rightIdx++];
            }
        }

        // 남아있는 값 처리
        while (leftIdx <= center) {
            arr[currIdx++] = tmp[leftIdx++];
        }
        while (rightIdx <= center) {
            arr[currIdx++] = tmp[rightIdx];
        }
    }
}
