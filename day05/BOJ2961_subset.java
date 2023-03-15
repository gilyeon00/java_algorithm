package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2961_subset {
    static int N, totalCnt;
    static boolean[] isVisited;
    static int[][] arr;
    static ArrayList<Integer> checkSour;
    static ArrayList<Integer> checkDry;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        subset(0);
        System.out.println(min);

    }

    private static void subset(int cnt) {
        checkSour = new ArrayList<>();
        checkDry = new ArrayList<>();
        int multi=1;
        int sum=0;
        if (cnt == N) {
                for (int i = 0; i < N; i++) {
                    if(isVisited[i]){
                        checkSour.add(arr[i][0]);
                        checkDry.add(arr[i][1]);
                    }
                }
                if (checkSour.size() != 0) {
                    for (int i = 0; i < checkSour.size(); i++) {
                        multi *= checkSour.get(i);
                        sum += checkDry.get(i);
                    }
                    if (Math.abs(multi - sum) < min) min = Math.abs(multi - sum);
                }
            return;
        }

        isVisited[cnt] = true;
        subset(cnt + 1);

        isVisited[cnt] = false;
        subset(cnt + 1);
    }

}
