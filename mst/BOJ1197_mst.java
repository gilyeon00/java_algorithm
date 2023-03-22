package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge{
    int from, to, weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class BOJ1197_mst {
    static int V, E;
    static Edge[] edgeList; // 간선 리스트

    // 유니온 파인드
    static int[] parent;

    // 부모 노드 초기화
    static void make(){
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
    }

    // 부모 노드 반환
    static int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // union
    static boolean union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent == bParent) {
            return false;
        }
        parent[bParent] = aParent;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());   // V: 정점의 개수
        E = Integer.parseInt(st.nextToken());   // E: 간선의 개수
        edgeList = new Edge[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(from, to, weight);
        }

        // 최소 가중치부터 봐야하니 정렬 필요
        Arrays.sort(edgeList, (e1, e2) -> e1.weight - e2.weight);

        make(); // 부모노드 초기화

        int edgeCnt = 0;
        int totalWeight = 0;
        for (Edge e : edgeList) {
            if(union(e.from, e.to)){
                edgeCnt++;
                totalWeight += e.weight;
                if (edgeCnt == V - 1) {
                    break;
                }
            }
        }

        System.out.println(totalWeight);

        br.close();
    }
}
