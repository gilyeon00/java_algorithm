package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kb1반_알고리즘3번_정길연 {
    static int[][] arr;
    static boolean flag = true;
    static int cnt;
    static boolean[][] isVisited;
    static int[] dx = {0, -1, 1, 0,  0, 1, -1,  1, -1}; // 0본인, 1위, 2아래, 3오른쪽, 4왼쪽, 5오른쪽위대각, 6오른쪽아래대각, 7왼쪽위대각, 8왼쪽아래대각
    static int[] dy = {0,  0, 0, 1, -1, 1,  1, -1, -1};

    public static void main(String[] args) throws IOException {
        // 박연진 - 검은바둑알, 문동은 - 흰바둑알
        // 박연진승 - 1, 문동은승 -2, nothing - 0
        // 둘중 하나 이기면, 다음줄 연속된 바둑알 가장왼쪽에 놓인 바둑알 위치 출력
        // 검은색 - 1, 흰색 - 2, nothing - 0

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[19][19];
        isVisited = new boolean[19][19];

        for (int i = 0; i < 19; i++) {
            String[] s =  br.readLine().split(" ");
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        dfs(0,0, 0,0); // 시작할 x, y, cnt

    }

    private static void dfs(int a, int b, int cnt, int last) {
        for (int i = 0; i < 9; i++) {
            if (cnt >= 5) {
                System.out.println(a + " + " + b);
                return;
            }

            int nx = a + dx[i];
            int ny = b + dy[i];

            if (nx < 0 || nx > 18 || ny < 0 || ny > 18) continue;

            if (arr[nx][ny] == 0 && !isVisited[nx][ny]) {
                isVisited[nx][ny] = true;
                dfs(nx,ny,0,0);
            } else if (arr[nx][ny] == 1 && !isVisited[nx][ny]) {
                if(last == 2) dfs(nx, ny, 0,0);
                else{
                    isVisited[nx][ny] = true;
                    dfs(nx,ny,cnt+1,1);
                }
            } else if (arr[nx][ny] == 2 && !isVisited[nx][ny] && last == 2) {
                if(last == 1) dfs(nx, ny, 0,0);
                else{
                    isVisited[nx][ny] = true;
                    dfs(nx,ny,cnt+1,2);
                }
            } else continue;
        }
//        if (arr[a][b] == 0) {
//            isVisited[a][b] = true;
//            if(b == 0 || b == 18) {     // 가로 벗어나면
//                if(a >= 0 && a < 19 && !isVisited[a+1][b]) dfs(a + 1, b,0);     // 세로가 범위안에 들면
//                else flag = false;  // 끝까지 갔을 때
//            }
//            dfs(a, b + 1,0);
//        } else {
//            if (arr[a][b] == 1){    // 검은색
//                isVisited[a][b] = true;
//                for (int i = 0; i < 8; i++) {
//                    int nx = a + dx[i];
//                    int ny = b + dy[i];
//                    if (nx < 0 || nx > 18 || ny < 0 || ny > 18) continue;
//                    if (arr[nx][ny] == 1 && !isVisited[nx][ny]) {
//                        cnt += 1;
//                        dfs(nx, ny, cnt);
//                    } else continue;
//                }
//            } else if (arr[a][b] == 2) {
//                isVisited[a][b] = true;
//                for (int i = 0; i < 8; i++) {
//                    int nx = a + dx[i];
//                    int ny = b + dy[i];
//                    if (nx < 0 || nx > 18 || ny < 0 || ny > 18) continue;
//                    if (arr[nx][ny] == 2 && !isVisited[nx][ny]) {
//                        cnt += 1;
//                        dfs(nx, ny, cnt);
//                    } else continue;
//                }
//            }
//        }




    }

}
