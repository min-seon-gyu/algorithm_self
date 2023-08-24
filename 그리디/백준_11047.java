package 그리디;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 백준_11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Integer[] arr = new Integer[N];

        for(int i = 0; i < N ; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int count = 0;

        for(int i = 0; i<N ; i++){

            if((K / arr[i]) >= 1){
                count += (K / arr[i]);
                K = (K % arr[i]);
            }
        }

        System.out.println(count);
    }
}
