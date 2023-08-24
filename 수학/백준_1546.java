package 수학;

import java.util.Scanner;

public class 백준_1546 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double sum = 0.0;
        int max = 0;

        for(int i =0; i < N ; i++){
            int num = sc.nextInt();
            sum += num;
            if(max < num) {
                max = num;
            }
        }

        System.out.print(sum / max * 100 / N);
    }
}
