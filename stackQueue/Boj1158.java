package stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s =  br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k =  Integer.parseInt(s[1]);

        ArrayList people = new ArrayList();
        for(int i=1; i<=n; i++){
            people.add(i);
        }

        int curr = 0;
        ArrayList  resultArr = new ArrayList();
        while (!people.isEmpty()){
            int target = (curr + (k-1)) % people.size();
            resultArr.add (people.get( target ));
            if(people.size() != 1)  resultArr.add(", ");
            people.remove(target);
            curr = target;
        }

        System.out.print("<");
        for(Object j : resultArr){
            System.out.print(j);
        }
        System.out.print(">");

    }
}
