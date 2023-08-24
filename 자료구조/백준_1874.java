package 자료구조;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class 백준_1874 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();

        }

        int start = 1;
        boolean result = true;
        Stack<Integer> stack = new Stack<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < arr.length; i++) {


            if(arr[i] >= start){

                while (arr[i] >= start){
                    stack.push(start);
                    start++;
                    bw.write("+\n");
                }
                stack.pop();
                bw.write("-\n");
            }

            else if(arr[i] < start){
                if(stack.pop() != arr[i]){
                    result = false;
                    System.out.println("No");
                    break;

                }
                bw.write("-\n");
            }



        }
        bw.flush();
        bw.close();
    }
}
