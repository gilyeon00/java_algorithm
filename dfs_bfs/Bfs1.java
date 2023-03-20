package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

    public class Bfs1 {

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

            BFS();
        }

        private static void BFS() {
            Queue<Integer> que = new LinkedList();

            // 시작 노드 En-queue : 루트 노드
            que.offer(1);

            while (!que.isEmpty()) {
                // De-queue (방문)
                int currIndex = que.poll();
                System.out.print(nodes[currIndex] + " ");

                // En-queue
                if (2*currIndex <= lastIndex) que.offer(2*currIndex);
                if (2*currIndex + 1 <= lastIndex) que.offer(2*currIndex + 1);
            }
        }

    }