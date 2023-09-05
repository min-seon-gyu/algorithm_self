package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+2];
        int[] t = new int[N+1];
        int[] p = new int[N+1];

        for(int i = 1 ; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= N ; i++){
            if(i + t[i] <= N+1){
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }

            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[N+1]);
    }
}
