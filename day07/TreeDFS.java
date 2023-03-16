package day07;

import java.util.Scanner;

public class TreeDFS {

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

        DFS(1); // 루트 노드부터 탐색

    }

    private static void DFS(int currIdx) {
        System.out.println(nodes[currIdx]);
        if(currIdx*2 <= lastIndex) DFS(currIdx*2); // 왼쪽 자식
        if(currIdx*2+1 <= lastIndex) DFS(currIdx * 2 + 1); //   오른쪽 자식노드 방문
    }
}
