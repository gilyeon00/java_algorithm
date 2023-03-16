package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11047_Greedy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int cnt =0;
        for (int i = arr.size() - 1; i > -1; i--) {
            if (K >= arr.get(i)) {
                cnt += K / arr.get(i);
                K %= arr.get(i);
            } else continue;


        }

        System.out.println(cnt);

    }
}
