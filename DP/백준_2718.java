package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T ; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[5][N+2];
            dp[0][1] = 1;
            for(int j = 2 ; j <= N+1 ; j++){
                dp[0][j] = dp[0][j-2] + dp[0][j-1] + dp[1][j-1] + dp[2][j-1] + dp[4][j-1];
                dp[1][j] = dp[0][j-1] + dp[2][j-1];
                dp[2][j] = dp[0][j-1] + dp[1][j-1];
                dp[3][j] = dp[4][j-1];
                dp[4][j] = dp[0][j-1] + dp[3][j-1];
            }
            sb.append(dp[0][N+1]).append("\n");
        }

        System.out.println(sb);
    }
}
