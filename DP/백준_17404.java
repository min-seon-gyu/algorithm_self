package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] colors = new int[N][3];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; j++){
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i = 0 ; i < 3 ; i++){
            int[][] dp = new int[N][3];

            dp[0][0] = 1001;
            dp[0][1] = 1001;
            dp[0][2] = 1001;

            dp[0][i] = colors[0][i];

            for(int j = 1 ; j < N ; j++){
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + colors[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + colors[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + colors[j][2];
            }
            for(int j = 0 ; j < 3 ; j++){
                if(j == i) continue;
                answer = Math.min(answer, dp[N-1][j]);
            }
        }
        System.out.println(answer);
    }
}
