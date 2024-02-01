package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2666 {
    static int answer = Integer.MAX_VALUE;
    static int[][][] dp;
    static int[] values;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        values = new int[M+1];

        for(int i = 1 ; i <= M ; i++){
            values[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[M+1][N+1][N+1];

        for(int i = 1 ; i <= M ; i++){
            for(int j = 1 ; j <= N ; j++){
                for(int k = 1 ; k <= N ; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        //solve_brute_force(1, 0, A, B);
        //System.out.println(answer);

        System.out.println(solve_dp(1, A, B));
    }

    private static int solve_dp(int idx, int a, int b) {
        if(idx == values.length){
            return 0;
        }

        if(dp[idx][a][b] != -1){
            return dp[idx][a][b];
        }

        dp[idx][a][b] = 0;
        int value = values[idx];

        dp[idx][a][b] = Math.min(Math.abs(value - a) + solve_dp(idx + 1, value, b),
                Math.abs(value - b) + solve_dp(idx + 1, a, value));

        return dp[idx][a][b];
    }

    private static void solve_brute_force(int idx, int sum, int a, int b) {
        if(idx == values.length){
            answer = Math.min(answer, sum);
            return;
        }

        int value = values[idx];

        solve_brute_force(idx + 1, sum + Math.abs(value - a), value, b);
        solve_brute_force(idx + 1, sum + Math.abs(value - b), a, value);
    }
}
