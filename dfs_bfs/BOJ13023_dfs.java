package dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13023_dfs {
    static int N, M;
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // N : 사람 수 (노드)
        M = Integer.parseInt(st.nextToken());   // M : 친구 관계 수 (간선)

        arr = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from].add(to);
            arr[to].add(from);
        }

        /*
            한 노드에서 모든게 다 이어진다면 1 출력
         */
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
        }

        if(flag) System.out.println(1);
        else System.out.println(0);

        br.close();
    }

    private static void dfs(int currNode, int cnt) {
        if(flag) return;
        if (cnt == 5) {     // 5개 노드가 이어지려면 cnt 가 4개면 된다.
            flag = true;
            return;
        }

        for (int node : arr[currNode]){
            if (!visited[node]) {
                visited[node] = true;
                dfs(node, cnt+1);
                visited[node] =false;       // 다음 노드 탐색을 위해 false 로 초기화
            }
        }

    }
}
