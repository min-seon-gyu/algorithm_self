package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_1940 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N ; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int startIndex = 0;
        int endIndex = N - 1;
        int count = 0;

        while(startIndex < endIndex){

            if(arr[startIndex] + arr[endIndex] == M){
                count++;
                endIndex--;
                startIndex++;

            }
            else if(arr[startIndex] + arr[endIndex] < M){
                startIndex++;
            }
            else if(arr[startIndex] + arr[endIndex] > M){
                endIndex--;
            }


        }
        System.out.println(count);
    }
}
