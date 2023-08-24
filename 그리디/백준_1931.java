package 그리디;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 백준_1931 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N][2];

        for(int i = 0; i< N ; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] data1, int[] data2){
                if(data1[1] == data2[1]){
                    return data1[0] - data2[0];
                }

                return data1[1] - data2[1];
            }
        });

        int count = 0;
        int end = 0;

        for(int i = 0; i< N ; i++){
            if(arr[i][0] > end){
                end = arr[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
}
