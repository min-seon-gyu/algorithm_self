package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_2655 {

    public static class Wall{
        int a, h, w;

        public Wall(int a, int h, int w) {
            this.a = a;
            this.h = h;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][N+1];
        Wall[] wall = new Wall[N+1];
        wall[0] = new Wall(0,0,0);

        for(int i = 1 ; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            wall[i] = new Wall(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        int cnt = 1;

        for(int i = 1 ; i <= N ; i++){
            dp[1][i] = wall[i].h;
            answer = Math.max(answer, dp[i][1]);
        }


        for(int i = 2 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                for(int k = 1 ; k <= N ; k++){
                    if(wall[j].a < wall[k].a && wall[j].w < wall[k].w && dp[i-1][k] != 0){
                        dp[i][j] = Math.max(dp[i-1][k] + wall[j].h, dp[i][j]);
                        if(answer <= dp[i][j]){
                            answer = dp[i][j];
                            cnt = i;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        int number = 0;
        for(int i = cnt ; i > 0 ; i--){
            for(int j = 1 ; j <= N ; j++){
                if(dp[i][j] == answer && wall[number].w < wall[j].w && wall[number].a < wall[j].a){
                    sb.append(j).append("\n");
                    answer -= wall[j].h;
                    number = j;
                }
            }
        }
        System.out.println(sb);
    }
}
