package LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            arr[i][0] = i+1;
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[]a2){
                return a1[0] - a2[0];
            }
        });

        int[] dp = new int[N];
        Arrays.fill(dp, N+1);
        int count = 0;

        for(int i = 0 ; i < N ; i++){

            if(count == 0){
                dp[count] = arr[i][1];
                count++;
                continue;
            }

            if(dp[count - 1] < arr[i][1]){
                dp[count] = arr[i][1];
                count++;
            }else{
                int i1 = Arrays.binarySearch(dp, arr[i][1]);
                if(i1 < 0) i1 = (i1 + 1) * -1;
                dp[i1] = arr[i][1];
            }
        }

        System.out.println(N - count);

    }
}
