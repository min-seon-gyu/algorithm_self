package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 1){
            System.out.println(3);
            return;
        }else if(N == 0){
            System.out.println(0);
            return;
        }

        int[][][] dp = new int[N+1][2][3];

        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        dp[1][1][0] = 1;

        for(int i = 2 ; i <= N ; i++){
            dp[i][0][0] = (dp[i-1][0][0] % 1000000) + (dp[i-1][0][1] % 1000000) + (dp[i-1][0][2] % 1000000);
            dp[i][0][1] = dp[i-1][0][0] % 1000000;
            dp[i][0][2] = dp[i-1][0][1] % 1000000;
            dp[i][1][0] = (dp[i-1][0][0] % 1000000) + (dp[i-1][0][1] % 1000000) + (dp[i-1][0][2] % 1000000) + (dp[i-1][1][0] % 1000000) + (dp[i-1][1][1] % 1000000) + (dp[i-1][1][2] % 1000000);
            dp[i][1][1] = dp[i-1][1][0] % 1000000;
            dp[i][1][2] = dp[i-1][1][1] % 1000000;
        }

        int answer = 0;
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                answer = answer + (dp[N][i][j] % 1000000);
            }
        }

        System.out.println(answer % 1000000);

    }
}
