package dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717_unionfind {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // n+1개 집합
        M = Integer.parseInt(st.nextToken());   // 입력 연산 개수

        parent = new int[N+1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(op == 0){
                union(a,b);
            } else if(op == 1){
                if (find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }

        br.close();
    }

    private static void union(int a, int b) {
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
