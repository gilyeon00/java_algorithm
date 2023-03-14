package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9742_perm {
    static int target, totalNum;
    static boolean[] isVisited;
    static char[] charArr; //  선택한 문자
    private static String answer;

    private static void perm(int cnt, String str) {

        if (cnt == str.length()) {
            totalNum ++;
            if (totalNum == target){
                answer = new String(charArr);
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if(isVisited[i]) continue;
            isVisited[i] = true;
            charArr[cnt] = str.charAt(i);
            perm(cnt + 1, str);
            isVisited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line);
            String str = st.nextToken();
            target = Integer.parseInt(st.nextToken());

            isVisited = new boolean[str.length()];
            charArr = new char[str.length()];
            totalNum = 0;

            perm(0, str);

            if (totalNum < target) {
                answer = "No permutation";
            }
            System.out.println(str + " " + target + " = " + answer);
        }
    }



}
