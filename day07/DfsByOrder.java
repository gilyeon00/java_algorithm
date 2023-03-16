package day07;

import java.util.Scanner;

public class DfsByPreOrder {

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

        DFSByPreOrder(1); // 루트 노드부터 탐색

    }

    private static void DFSByPreOrder(int currIdx) {    // 전위순회
        System.out.println(nodes[currIdx]);
        if(currIdx*2 <= lastIndex) DFSByPreOrder(currIdx*2); // 왼쪽 자식
        if(currIdx*2+1 <= lastIndex) DFSByPreOrder(currIdx * 2 + 1); //   오른쪽 자식노드 방문
    }

    private static void DFSByPreOrder(int currIdx) {    // 전위순회
        System.out.println(nodes[currIdx]);
        if(currIdx*2 <= lastIndex) DFSByPreOrder(currIdx*2); // 왼쪽 자식
        if(currIdx*2+1 <= lastIndex) DFSByPreOrder(currIdx * 2 + 1); //   오른쪽 자식노드 방문
    }
    
}
