package 구현;

import java.util.Scanner;

public class 백준_12891 {

    static int[] check;
    static int[] solution;

    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        check = new int[4];
        solution = new int[4];
        count = 0;

        String str = sc.next();
        char[] arr = str.toCharArray();

        for(int i = 0; i< 4 ; i++){
            solution[i] = sc.nextInt();
        }

        for(int i = 0; i < M ; i++){
            if(arr[i] == 'A'){
                check[0]++;
            }
            else if (arr[i] == 'C') {
                check[1]++;
            }
            else if (arr[i] == 'G') {
                check[2]++;
            }
            else if (arr[i] == 'T') {
                check[3]++;
            }
        }

        CheckData(check, solution);

        int startIndex = 0;
        while(startIndex + M < N)
        {

            if(arr[startIndex] == 'A'){
                check[0]--;
            }
            else if (arr[startIndex] == 'C') {
                check[1]--;
            }
            else if (arr[startIndex] == 'G') {
                check[2]--;
            }
            else if (arr[startIndex] == 'T') {
                check[3]--;
            }

            if(arr[startIndex+M] == 'A'){
                check[0]++;
            }
            else if (arr[startIndex+M] == 'C') {
                check[1]++;
            }
            else if (arr[startIndex+M] == 'G') {
                check[2]++;
            }
            else if (arr[startIndex+M] == 'T') {
                check[3]++;
            }

            CheckData(check, solution);

            startIndex++;
        }

        System.out.println(count);
    }


    public static void CheckData(int[] arr, int[] arr2){
        if(arr[0] >= arr2[0] && arr[1] >= arr2[1] && arr[2] >= arr2[2] && arr[3] >= arr2[3]){
            count++;
        }
    }
}
