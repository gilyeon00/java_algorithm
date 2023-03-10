package day01_StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Boj2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque deque = new LinkedList();

        for (int i = 1; i<=n; i++){
            deque.add(i);
        }

        while(deque.size() != 1){
            deque.pop();
            int tmp = (int)deque.pop();
            deque.addLast(tmp);
        }

        int answer = (int) deque.pop();
        System.out.println(answer);
    }
}
