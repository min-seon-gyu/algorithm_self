package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 백준_7490 {
    static StringBuilder sb = new StringBuilder();
    static String[] sign = {" ", "-", "+"};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            N = Integer.parseInt(br.readLine());
            add(1, 1, 0,1,"1");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void add(int c, int num, int sum, int sign, String express) {
        if(N == c){
            if(sum + num*sign == 0){
                sb.append(express).append("\n");
            }
            return;
        }


        add(c+1, num*10+c+1, sum, sign, express+" "+Integer.toString(c+1));
        add(c+1, c+1, sum + num*sign, 1,express+"+"+Integer.toString(c+1));
        add(c+1, c+1, sum + num*sign, -1, express+"-"+Integer.toString(c+1));

    }
}
