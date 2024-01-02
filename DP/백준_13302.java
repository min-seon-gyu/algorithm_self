package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_13302 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][41];
        check = new boolean[N+1];

        if(M != 0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < M ; i++){
                check[Integer.parseInt(st.nextToken())] = true;
            }
        }

        for(int i=0; i< N+1; i++) {
            Arrays.fill(arr[i], -1);
        }

        System.out.println(solve(1, 0));

    }

    static int solve(int day, int coupon) {

        if(day > N) return 0;

        if(arr[day][coupon] != -1) return arr[day][coupon];


        arr[day][coupon] = Integer.MAX_VALUE;
        if(check[day]) {
            return arr[day][coupon] = Math.min(arr[day][coupon], solve(day+1, coupon));
        }
        else {
            if(coupon >= 3 ) {
                arr[day][coupon] = Math.min(arr[day][coupon], solve(day+1, coupon-3));
            }
            arr[day][coupon] = Math.min(arr[day][coupon], solve(day+1, coupon)+ 10000);
            arr[day][coupon] = Math.min(arr[day][coupon], solve(day+3, coupon+1) +25000);
            arr[day][coupon] = Math.min(arr[day][coupon], solve(day+5, coupon+2) + 37000);
        }

        return arr[day][coupon];
    }
}
