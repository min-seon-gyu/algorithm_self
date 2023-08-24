package 수학;

import java.util.Scanner;

public class 백준_10986 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] sum = new int[N+1];
        int[] remainder = new int[M];
        int count = 0;


        for(int i = 1 ; i<= N ; i++){
            sum[i] = sum[i-1] + sc.nextInt();

            int remain = sum[i] % 3;
            if(remain ==0){
                count++;
            }

            remainder[remain]++;
        }

        for(int i= 0; i< M; i++){
            if(remainder[i] > 1){

                count += remainder[i] * (remainder[i] - 1) /2;
            }
        }
        System.out.println(count);
    }
}
