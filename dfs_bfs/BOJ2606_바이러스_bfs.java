package dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606_바이러스_bfs {

    static int N, S, cnt;
    static ArrayList<Integer>[] arr;
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());   // 컴퓨터 수
        S = Integer.parseInt(br.readLine());   // 연결되어있는 쌍의 개수

        visited = new boolean[N + 1];
        arr = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < S+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        bfs(1);

        System.out.println(cnt);

        br.close();
    }

    private static void bfs(int startNode) {
        Queue<Integer> q = new LinkedList();
        q.offer(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int x : arr[node]) {
                if (!visited[x]) {
                    q.offer(x);
                    visited[x] = true;
                    cnt ++;
                }
            }
        }

    }
}

