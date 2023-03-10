package day01_StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj17608 {
    public static int solution(Stack stickStack){
        int max = 0;
        int cnt = 0;
        while(!stickStack.isEmpty()){
            int stick = (int) stickStack.pop();
            if(max < stick ){
                max = stick;
                cnt ++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack stickStack = new Stack();
        while(n > 0){
            int stick = Integer.parseInt(br.readLine());
            stickStack.push(stick);
            n --;
        }
        System.out.println(solution(stickStack));

    }
}