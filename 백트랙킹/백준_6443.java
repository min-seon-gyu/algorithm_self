package 백트랙킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_6443 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();

            int[] count = new int[26];
            char[] answer = new char[str.length()];


            for(int j = 0 ; j < str.length(); j++){
                count[str.charAt(j) - 'a']++;
            }
            com(str.length(), 0, count,answer);
        }

        System.out.println(sb);
    }

    public static void com(int n, int c, int[] check, char[] answer){
        if(n == c){
            sb.append(String.valueOf(answer)).append("\n");
            return;
        }

        for(int j = 0 ; j < check.length ; j++){
            if(check[j] > 0){
                answer[c] = (char)(97+j);
                check[j]--;
                com(n, c+1, check, answer);
                check[j]++;
            }
        }
    }
}
