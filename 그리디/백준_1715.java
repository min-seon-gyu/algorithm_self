package 그리디;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 백준_1715 {
    public static void start() {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Integer> arr = new PriorityQueue<>();

        for(int i = 0; i < N ; i++){
            arr.add(sc.nextInt());
        }

        int sum = 0;
        while(arr.size() > 1){

            int num1 = arr.poll();
            int num2 = arr.poll();
            sum += num1 + num2;
            arr.add(num1 + num2);

        }

        System.out.println(arr.poll());

    }
}
