package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            dp[arr[i]] = 1;
        }

        for(int i = 1 ; i <= k ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i - arr[j] > 0){
                    if(dp[i - arr[j]] == Integer.MAX_VALUE) continue;
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }


        System.out.println(dp[k] != Integer.MAX_VALUE ? dp[k] : -1);
    }
}
