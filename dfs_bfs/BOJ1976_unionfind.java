package dfs_bfs;

import javax.xml.stream.events.StartDocument;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1976_unionfind {
    static int N, M;
    static int[] parent;
    static int[][] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());    // N : 도시의 수
        M = Integer.parseInt(br.readLine());    // M : 예행 계획에 속한 도시 수

        parent = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }

        arr = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int target = find(Integer.parseInt(st.nextToken()));

        boolean flag = true;
        for (int i = 1; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (find(tmp) != target) {
                flag = false;
                break;
            }
        }

        if(!flag) System.out.println("NO");
        else System.out.println("YES");

        br.close();
    }

    private static void union (int a, int b) {
        a = find(a);
        b = find(b);
        if (a <= b) {
            parent[b] = a;
        } else parent[a] = b;
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

}
