package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;

        int[][] dp = new int[N+1][10];

        for(int i = 1 ; i < 10 ; i++){
            dp[1][i] = 1;
        }

        for(int i = 2 ; i <= N ; i++){
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];

            for(int j = 1 ; j <= 8 ; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }

        for(int value : dp[N]){
            answer = (answer + value) % 1000000000;
        }
        System.out.println(answer);

    }
}
