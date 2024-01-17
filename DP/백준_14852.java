package DP;

import java.io.IOException;
import java.util.Scanner;

public class 백준_14852 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] dp = new long[N+1];
        long[] sum = new long[N+1];

        if(N == 1){
            System.out.println(2);
            return;
        }else if(N == 2){
            System.out.println(7);
            return;
        }else if(N == 3){
            System.out.println(22);
            return;
        }

        dp[1] = 2l;
        dp[2] = 7l;
        dp[3] = 22l;

        for(int i = 4 ; i <= N ; i++){
            sum[i-3] = sum[i-4] + dp[i-3];
            dp[i] = (dp[i-1] * 2 + dp[i-2] * 3 + sum[i-3] * 2 + 2) % 1000000007;
        }

        System.out.println(dp[N]);
    }
}
