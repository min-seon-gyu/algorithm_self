package LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for(int i = 1 ; i <= a.length() ; i++ ){
            for(int j = 1 ; j <= b.length() ; j++){
                int aIdx = i - 1;
                int bIdx = j - 1;
                if(a.charAt(aIdx) == b.charAt(bIdx)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        // 현재값을 기준으로 왼쪽 또는 위쪽에 값이 같은지 체크

        Stack<Character> stack = new Stack<>();

        int aIdx = a.length();
        int bIdx = b.length();

        while(aIdx > 0 && bIdx > 0){
            if(dp[aIdx-1][bIdx] == dp[aIdx][bIdx]){
                aIdx -= 1;
            }else if(dp[aIdx][bIdx-1] == dp[aIdx][bIdx]){
                bIdx -= 1;
            }else{
                stack.push(a.charAt(aIdx-1));
                aIdx -= 1;
                bIdx -= 1;
            }
        }

        System.out.println(stack.size());
        if(stack.size() > 0){
            while(!stack.isEmpty()){
                System.out.print(stack.pop());
            }
        }
    }
}
