package 수학;

import java.util.Scanner;

public class 백준_11720 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        char[] arr =  str.toCharArray();
        int sum = 0;

        for(int i = 0; i < N ; i++){
            sum += arr[i] - '0';
        }

        System.out.print(sum);
    }
}
