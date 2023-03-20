package dfs_bfs;

import java.util.Scanner;

public class DfsByOrder {

    static char[] nodes;
    static int lastIndex, SIZE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SIZE = sc.nextInt();
        nodes = new char[SIZE+1];
        lastIndex = SIZE;

        for (int i = 0; i < SIZE; i++) {
            nodes[i+1] = (char)('A' + i);
        }

        DFSByPreOrder(1);
        System.out.println();
        DFSByInOrder(1);
        System.out.println();
        DFSByPostOrder(1);

    }

    // 전위순회
    private static void DFSByPreOrder(int currIdx) {
        System.out.print(nodes[currIdx]);
        if(currIdx*2 <= lastIndex) DFSByPreOrder(currIdx*2); // 왼쪽 자식
        if(currIdx*2+1 <= lastIndex) DFSByPreOrder(currIdx * 2 + 1); //   오른쪽 자식노드 방문
    }

    // 준위순회
    private static void DFSByInOrder(int currIdx) {
        if(currIdx*2 <= lastIndex) DFSByInOrder(currIdx*2); // 왼쪽 자식
        System.out.print(nodes[currIdx]);
        if(currIdx*2+1 <= lastIndex) DFSByInOrder(currIdx * 2 + 1); //   오른쪽 자식노드 방문
    }

    // 후위
    private static void DFSByPostOrder(int currIdx) {
        if(currIdx*2 <= lastIndex) DFSByPostOrder(currIdx*2); // 왼쪽 자식
        if(currIdx*2+1 <= lastIndex) DFSByPostOrder(currIdx * 2 + 1); //   오른쪽 자식노드 방문
        System.out.print(nodes[currIdx]);
    }


}
