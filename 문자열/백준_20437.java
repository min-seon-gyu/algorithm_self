package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if(K == 1){
                sb.append(1 + " " + 1).append("\n");
                continue;
            }

            int[] check = new int[26];

            for(int j = 0 ; j < W.length() ; j++){
                char c = W.charAt(j);
                check[c-'a']++;
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int j = 0 ; j < W.length(); j++){
                char c = W.charAt(j);
                int count = 1;
                if(check[c-'a'] < K) continue;
                for(int k = j +1 ; k < W.length(); k++){
                    if(c == W.charAt(k)) count++;

                    if(count == K){
                        int length = k-j+1;
                        min = Math.min(min, length);
                        max = Math.max(max, length);
                        break;
                    }
                }
            }
            if(min != Integer.MAX_VALUE && max != Integer.MIN_VALUE){
                sb.append(min + " " + max).append("\n");
            }else{
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }

}
