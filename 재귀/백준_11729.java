package 재귀;

import java.util.Scanner;



public class 백준_11729   {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Calculation(N, 1, 3);

        System.out.println(sb);
    }

    public static void Calculation(int count, int start, int end){

        if(count == 1){
            sb.append(start + " " + end + "\n");
            return;
        }

        Calculation(count-1, start, 6 - start - end);

        sb.append(start + " " + end + "\n");

        // STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
        Calculation(count - 1, 6 - start - end, end);



    }
}
