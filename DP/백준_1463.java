package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int number = 0;
        int count = 0;
        while(true){
            String str = String.valueOf(number);
            if(str.contains("666")) count++;

            if(count == n){
                System.out.println(number);
                return;
            }

            number++;
        }
    }
}
