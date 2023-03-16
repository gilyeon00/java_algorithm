package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2839_Greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> result = new ArrayList<>();

        int five = 0;
        int tmp;
        for (int i = 0; i < N; i++) {   // i는 5kg개수
            tmp = N;
            five = i * 5;
            tmp -= five;
            if(tmp < 0) break;
            if (tmp % 3 == 0) {
                result.add(i + tmp / 3);
            }
        }

        if (result.size() == 0) {
            System.out.println("-1");
            return;
        }

        Collections.sort(result);
        int minAns = result.get(0);
        System.out.println(minAns);

    }
}
