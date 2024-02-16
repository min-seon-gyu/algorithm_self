package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2643 {
    static class Paper implements Comparable<Paper>{
        int x,y;

        public Paper(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Paper p){
            if(this.x == p.x){
                return this.y - p.y;
            }
            return this.x - p.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Paper[] arr = new Paper[N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x < y){
                arr[i] = new Paper(y,x);
            }else{
                arr[i] = new Paper(x,y);
            }
        }

        Arrays.sort(arr);

        int[] dp = new int[N];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i].x >= arr[j].x && arr[i].y >= arr[j].y) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max ,dp[i]);
                }
            }
        }


        System.out.println(max);
    }
}
