package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2023 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        go(1,2);
        go(1,3);
        go(1,5);
        go(1,7);
        System.out.println(sb);
    }

    private static void go(int count, int value) {

        if(count == N){
            sb.append(value).append("\n");
            return;
        }

        for(int i = 1 ; i <= 9 ; i++){
            if(i % 2 == 0){
                continue;
            }

            if(isPrime(value * 10 + i)){
                go(count + 1 , value * 10 + i);
            }

        }
    }
    private static boolean isPrime(int value){
        for(int i = 2 ; i*i <= value ; i++){
            if(value % i == 0){
                return false;
            }
        }
        return true;
    }
}
