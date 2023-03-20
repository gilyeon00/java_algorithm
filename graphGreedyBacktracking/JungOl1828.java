package graphGreedyBacktracking;

import java.io.*;
import java.util.*;

public class JungOl1828 {
    static StringTokenizer st;
    static int N;
    static int Refre;
    private static class Temperatures implements Comparable<Temperatures> {
        int min, max;

        public Temperatures(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public int compareTo(Temperatures o) {
            int diff = this.max - o.max;
            return diff != 0 ? diff : this.min- o.min;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        Temperatures[] temps = new Temperatures[N];
        Refre = N;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            temps[i] = new Temperatures(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(temps);
        int maxNum = temps[0].max;

        for(int i=0 ; i < N-1 ; i++) {
            if(maxNum >= temps[i+1].min) {
                Refre--;
            } else {
                maxNum = temps[i+1].max;
            }
        }

        System.out.println(Refre+"");
    }
}