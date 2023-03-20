//package dfs_bfs;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//import java.io.IOException;
//
//public class BOJ1260_DFS_BFS {
//    static int N, M, V;
//    static int[][] graph;
//    static boolean[] isVisited;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        V = Integer.parseInt(st.nextToken());
//
//        graph = new int[N+1][N+1];
//        isVisited = new boolean[N+1];
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//
//            graph[a][b] = graph[b][a] = 1;
//        }
//
////        System.out.println(Arrays.toString(graph));
//
//        dfs();
//        bfs(1);
//
//    }
//
//    private static void dfs(){
//
//    }
//
////    private static void bfs(int start){
////        Queue<Integer> q = new LinkedList();
////        q.add(start);
////        isVisited[start] = true;
////
////        while (!q.isEmpty()) {
////            int node = q.poll();
////            System.out.print(node + " ");
////
////            for (int i = 1; i <= N; i++) {
////                if (graph[start][i] == 1 && !isVisited[i]) {
////                    is
////                    q.add(i);
////                }
////            }
////        }
//
//    }
//}
