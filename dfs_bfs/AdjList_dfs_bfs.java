package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjList_dfs_bfs {

    static boolean[] visited;
    static ArrayList<Integer>[] adjList;    // 인접리스트
    static int N,E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        E = Integer.parseInt(br.readLine());    // 간선 개수
        N = Integer.parseInt(br.readLine());    // node 개수

        visited = new boolean[N];
        adjList = new ArrayList[N];

        //  인접리스트 각 위치에 빈 리스트 추가
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        // 인접리스트 노드 추가
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
        }

        System.out.print("BFS : ");
        bfs(0);

        System.out.println();
        visited = new boolean[N];

        System.out.print("DFS : ");
        dfs(0);

    }

    private static void bfs(int startNode) {
        Queue<Integer> q = new LinkedList<Integer>();

        // 시작 정점 En-queue : 0
        visited[startNode] = true;
        q.offer(startNode);


        while (!q.isEmpty()){
            // De-queue
            int currNode = q.poll();
            System.out.print(currNode + " ");

            // En-queue : currNode 의 인접 노드 en-queue
            for (int node : adjList[currNode]) {
                if(!visited[node]) {
                    q.offer(node);
                    visited[node] = true;
                }
            }

        }
    }

    private static void dfs(int currnode) {
        System.out.print(currnode + " ");

        for (int node : adjList[currnode]) {
            if (!visited[node]) {
                visited[node] = true;
                dfs(node);
            }
        }
    }

}

/*
7
8
0 1
0 2
1 3
1 4
3 5
4 5
5 6
2 6
 */