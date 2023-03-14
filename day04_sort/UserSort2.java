package day04_sort;

import java.util.ArrayList;
import java.util.Collections;

class Person2 {
    int age, money;

    public Person2(int age, int money) {
        this.age = age;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", money=" + money +
                '}';
    }
}

public class UserSort2 {
    public static void main(String[] args) {
        ArrayList<Person2> arr = new ArrayList<>();
        arr.add(new Person2(25, 100));
        arr.add(new Person2(20, 500));
        arr.add(new Person2(23, 400));
        arr.add(new Person2(21, 400));

        // 람다함수 이용
        Collections.sort(arr, (p1, p2) -> p1.money - p2.money); // p1과 p2는 파라미터
            // void 메서드명(Person1 p1, Person2 p2) return p1.money - p2.money
        System.out.println(arr.toString());

        // money가 같다면 age로 비교
        Collections.sort(arr, (p1, p2) -> p1.money != p2.money ? p1.money - p2.money : p1.age - p2.age);
    }

}
