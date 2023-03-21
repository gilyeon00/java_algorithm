package dfs_bfs;

import java.util.Arrays;

public class UnionFind {
    static  int N;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        N = 7;
        parents = new int[N];

        // 원소 별 서로소 집합 생성
        make();
        System.out.println("Parents : " + Arrays.toString(parents));

        // {0} U {1}
        union(0, 1);
        System.out.println("Parents : " + Arrays.toString(parents));

        // {0, 1} U {2}
        union(1, 2);
        System.out.println("Parents : " + Arrays.toString(parents));

        // 1과 2가 같은 집합인지 판단
        if (isSame(1, 2)) System.out.println("Same Set");
        else System.out.println("Disjoint Set");

        // {3} U {4}
        union(3, 4);
        System.out.println("Parents : " + Arrays.toString(parents));

        // {5} U {6}
        union(5, 6);
        System.out.println("Parents : " + Arrays.toString(parents));

        // 4와 6이 같은 집합인지 판단
        if (isSame(4, 6)) System.out.println("Same Set");
        else System.out.println("Disjoint Set");
    }

    // parent[] 초기 초기화
    static void make() {
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    // currNode의 부모 노드 반환
    static int find(int currNode) {
        if(parents[currNode] == currNode) return currNode;
        return parents[currNode] = find(parents[currNode]);
    }

    // x union y
    static void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if(xParent == yParent) return; //   같은 집합
        else parents[yParent] = xParent;
    }

    static boolean isSame(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (xParent == yParent) return true;
        else return false;
    }

}
