package 정렬;

import java.util.Scanner;

public class 백준_2750 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for(int i = 0; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }


        for(int i = 0; i< arr.length - 1 ; i++){
            boolean check = false;

            for(int j = 0; j < arr.length - 1 - i ; j++){

                if(arr[j] > arr[j+1]){
                    check = true;
                    swap(arr, j, j+1);
                }
            }
            if(!check){
                break;
            }
        }

        for(int value : arr){
            System.out.println(value);
        }
    }

    public static void swap(int[] arr, int firstIndex, int secondIndex){

        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
