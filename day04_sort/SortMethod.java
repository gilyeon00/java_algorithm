package day04_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortMethod {
    public static void main(String[] args) {
        // 1-1. 배열 정렬 - 정수
        int[] arr1 = {5,4,1,3,2};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        // 1-2. 배열 정렬 - 문자열
        String[] arr2 = {"apple", "samsung", "Lg", "google"}; // [Lg, apple, google, samsung]
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));


        // 2-1. ArrayList 정렬  - 정수
        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(5);
        arr3.add(1);
        arr3.add(923);
        arr3.add(3);
        Collections.sort(arr3);
        System.out.println(arr3.toString());    // [1, 3, 5, 923]

        // 2-2. ArrayList 정렬 - 문자
        ArrayList<String> arr4 = new ArrayList<>();
        arr4.add("apple");
        arr4.add("samsung");
        arr4.add("Lg");
        arr4.add("google");
        Collections.sort(arr4);
        System.out.println(arr4.toString());    // [Lg, apple, google, samsung]


        // 3-1. 내림차순 정렬 - Collections.reverseOrder()
        Integer[] arr5 = {5,4,1,3,2};   // Primitive 타입은 적용 불가
        Arrays.sort(arr5, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr5));      // [5, 4, 3, 2, 1]

    }
}
