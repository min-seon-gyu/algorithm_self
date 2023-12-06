package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));




        while(true){
            int N = Integer.parseInt(br.readLine());

            long[] dp = new long[N+1];

            if(N==1){
                System.out.println(1);
                return;
            }else if(N==2){
                System.out.println(1);
                return;
            }else if(N==3){
                System.out.println(2);
                return;
            }

            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 2;

            //21 = 50944540 	9,223,372,036,854,775,807
            //                    348,563,181,341,392,924
             //                    44,750,731,559,645,106
            //                    895,014,631,192,902,121

            for(int i = 4 ; i <= N ; i++){
                dp[i] = (dp[i-1] + dp[i-2]) * (i - 1);
            }

            System.out.println(dp[N]);
        }


    }
}
