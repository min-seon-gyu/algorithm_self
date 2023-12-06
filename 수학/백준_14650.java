package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_14650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int start = (int)Math.pow(10, N-1);
        int end  = (int)Math.pow(10,N);


        for(int i = start ; i < end ; i++){
            if(i % 3 != 0) continue;

            int value = i;
            boolean flag = false;

            while(value > 0){
                if(value % 10 == 0 || value % 10 == 1 || value % 10 == 2){
                    value /= 10;
                }else{
                    flag = true;
                    break;
                }
            }

            if(flag) continue;

            answer++;
        }
        System.out.println(answer);
    }
}
