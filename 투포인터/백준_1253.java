package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_1253 {
    public static void start() {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N ; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);


        int count = 0;

        for(int i =0; i < N ; i++){
            int target = arr[i];
            int startIndex = 0;
            int endIndex = N-1;

            while(startIndex < endIndex){

                if(arr[startIndex] + arr[endIndex] == target){
                    if(startIndex != i && endIndex != i){
                        count++;
                        break;

                    }
                    else if(startIndex == i){
                        startIndex++;
                    }
                    else if(endIndex == i){
                        endIndex--;
                    }
                }

                else if(arr[startIndex] + arr[endIndex] > target){
                    endIndex--;
                }

                else if(arr[startIndex] + arr[endIndex] < target){
                    startIndex++;
                }
            }
        }

        System.out.println(count);
    }
}
