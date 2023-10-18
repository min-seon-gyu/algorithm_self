package 비트마스킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][][] dp = new int[N+1][10][1024];

        int answer = 0;

        for(int i = 1 ; i <= 9 ; i++){
            dp[1][i][1 << i] = 1;
        }


        for(int i = 2 ; i <= N ; i++){
             for(int j = 0 ; j <= 9 ; j++){
                for(int k = 0; k < 1024 ; k++){
                    int check = k | 1 << j;
                    if(j == 0){
                        dp[i][0][check] = (dp[i][0][check] + dp[i-1][1][k]) % 1000000000;
                    }else if(j == 9){
                        dp[i][9][check] = (dp[i][9][check] + dp[i-1][8][k]) % 1000000000;
                    }else{
                        dp[i][j][check] = (dp[i][j][check] + dp[i-1][j-1][k] + dp[i-1][j+1][k]) % 1000000000;
                    }
                }
            }
        }

        for(int i = 0 ; i <= 9 ; i++){
            answer = (answer + dp[N][i][1023]) % 1000000000;
        }
        System.out.println(answer);
    }
}
