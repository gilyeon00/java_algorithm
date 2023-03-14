package day04_sort;

import java.util.ArrayList;
import java.util.Collections;

class Person implements Comparable<Person> {
    int age, money;

    public Person(int age, int money) {
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

    @Override
    public int compareTo(Person o) {
        // money를 기준으로 비교
//        if (this.money > o.money) {     // 나 > o return 양수
//            return 1;
//        } else if (this.money < o.money) {
//            return -1;
//        } else {    // 내가 가진 돈과 비교 대상이 가진 돈이 같은 경우
//            return 0;
//        }

//        if (this.money != o.money) {
//            return this.money - o.money;
//        } else {    // money 가 같은 경우, age 로 비교
//            return this.age - o.age;
//        }

        // 삼항연산자로 한 줄 표현
        return this.money != o.money ? this.money - o.money : this.age-o.age;
    }
}

public class UserSort1 {
    public static void main(String[] args) {
        ArrayList<Person> arr = new ArrayList<>();
        arr.add(new Person(25, 100));
        arr.add(new Person(20, 500));
        arr.add(new Person(23, 400));
        arr.add(new Person(21, 400));
        System.out.println(arr.toString());

        Collections.sort(arr);
        System.out.println(arr.toString());
    }

}
