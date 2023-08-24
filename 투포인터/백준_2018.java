package 투포인터;

import java.util.Scanner;

public class 백준_2018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int startIndex = 1;
        int endIndex = 1;
        int count = 1;
        int sum = 1;

        while(endIndex < N){

            if(sum == N){
                count++;
                sum -= startIndex;
                startIndex++;
            }
            else if(sum < N){
                endIndex++;
                sum += endIndex;
            }
            else if(sum > N){
                sum -= startIndex;
                startIndex++;
            }
        }
        System.out.println(count);
    }
}
