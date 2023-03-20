package dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724_dfs_bfs {

    static int N, M;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // node
        M = Integer.parseInt(st.nextToken());   // 간선

        visited = new boolean[N + 1];
        adjList = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i = 1; i < N + 1; i++) {
            if (visited[i] == true) {
                continue;
            }
//            System.out.println();
            bfs(i);
//            dfs(i);
            cnt++;
        }
//        System.out.println();
        System.out.println(cnt);

    }

    private static void bfs(int startNode) {
        Queue<Integer> q = new LinkedList();
        q.offer(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
            int currNode = q.poll();
//            System.out.print(currNode + " ");

            for (int node : adjList[currNode]) {
                if (!visited[node]) {
                    q.offer(node);
                    visited[node] = true;
                }
            }
        }

    }


//    private static void dfs(int currNode) {
//        visited[currNode] = true;
////        System.out.print(currNode+ " ");
//        for (int node : adjList[currNode]) {
//            if (!visited[node]) {
//                visited[node] = true;
//                dfs(node);
//            }
//        }
//
//    }

}
