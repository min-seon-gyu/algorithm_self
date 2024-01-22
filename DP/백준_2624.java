package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());


        int[] dp = new int[T+1];
        dp[0] = 1;

        // 100
        for(int i = 0 ; i < K ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            for(int j = T ; j >= 0 ; j--){
                for(int k = 1 ; k <= n && j - p * k >= 0 ; k++){
                    dp[j] += dp[j - p * k];
                }
            }
        }
        System.out.println(dp[T]);
    }
}
