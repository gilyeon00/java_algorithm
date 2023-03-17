package graphGreedyBacktracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663_NQueen_backtracking {

    static int N;
    static int arr[];
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        Queen(0);

        System.out.println(cnt);
    }

    private static void Queen(int idx) {
        if (idx == arr.length) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[idx] = i; // idx번째 줄(row)에 i 위치에 놓기

            if (isPossible(idx)) {    // idx번째 줄(row)이 가능한지
                Queen(idx + 1);
            }
        }
    }

    private static boolean isPossible(int rowIdx) {
        // 같은 열에 없는 지 확인
        for (int i = 0; i < rowIdx; i++) {
            if (arr[rowIdx] == arr[i]) {
                return false;
            }

            // 대각선 확인 - arr[rowIdx] : rowIdx줄의 Queen위치, rowIdx : col index  -> 행, 열 차가 같으면 대각선
            else if (Math.abs(rowIdx - i) == Math.abs(arr[rowIdx] - arr[i])) {
                return false;
            }
        }
        return true;
    }


}
