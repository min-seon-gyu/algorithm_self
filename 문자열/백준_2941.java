package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        int answer = 0;
        int idx = 0;

        while(idx < word.length()) {
            boolean flag = false;
            for(int i = 0 ; i < arr.length ; i++) {
                if(word.startsWith(arr[i], idx)) {
                    answer++;
                    idx += arr[i].length();
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                answer++;
                idx++;
            }
        }

        System.out.println(answer);
    }
}
