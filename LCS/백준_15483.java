package LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_15483 {
    static String target;
    static String origin;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();
        origin = br.readLine();

        dp = new int[target.length()][origin.length()];
        for(int i = 0 ; i < target.length(); i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solve(0,0));
    }

    private static int solve(int targetIdx, int originIdx) {


        if(targetIdx == target.length()){
            int value = origin.length() - originIdx;
            return value;
        }


        if(originIdx == origin.length()){
            int value = target.length() - targetIdx;
            return value;
        }

        if(dp[targetIdx][originIdx] != -1){
            return dp[targetIdx][originIdx];
        }

        dp[targetIdx][originIdx] = Integer.MAX_VALUE;

        char targetWord = target.charAt(targetIdx);
        char originWord = origin.charAt(originIdx);

        if(targetWord == originWord){
            dp[targetIdx][originIdx] = Math.min(solve(targetIdx+1, originIdx+1), dp[targetIdx][originIdx]);
        }else{
            dp[targetIdx][originIdx] = Math.min(solve(targetIdx+1, originIdx) + 1, dp[targetIdx][originIdx]);

            dp[targetIdx][originIdx] = Math.min(solve(targetIdx+1, originIdx+1) + 1, dp[targetIdx][originIdx]);

            dp[targetIdx][originIdx] = Math.min(solve(targetIdx, originIdx+1) + 1, dp[targetIdx][originIdx]);
        }

        return dp[targetIdx][originIdx];
    }
}
