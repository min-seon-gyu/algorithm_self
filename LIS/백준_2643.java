package LIS;

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
        Arrays.fill(dp, 1000);

        int count = 0;

        for(int i = 0 ; i < N ; i++){
            if(count == 0){
                dp[count] = arr[i].y;
                count++;
                continue;
            }

            if(dp[count-1] <= arr[i].y){
                dp[count] = arr[i].y;
                count++;
            }else{
                int idx = Arrays.binarySearch(dp, arr[i].y);
                if (idx < 0) {
                    idx = (idx + 1) * -1;
                }
                dp[idx] = arr[i].y;
            }
        }
        System.out.println(count);
    }
}
