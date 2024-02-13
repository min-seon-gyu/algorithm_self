package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_10835 {
    static int N;
    static int[] a;
    static int[] b;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        a = new int[N+1];
        b = new int[N+1];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= N ; i++){
            a[i] = Integer.parseInt(st1.nextToken());
            b[i] = Integer.parseInt(st2.nextToken());
        }

        dp = new int[N+1][N+1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(solve(1, 1));
    }

    private static int solve(int left, int right) {
        if(left > N || right > N){
            return 0;
        }

        if(dp[left][right] != -1){
            return dp[left][right];
        }


        dp[left][right] = Math.max(solve(left + 1, right), solve(left + 1, right + 1));
        if(a[left] > b[right]) dp[left][right] = Math.max(dp[left][right], solve(left, right + 1) + b[right]);

        return dp[left][right];

    }
}
