package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[M+1];

        Arrays.fill(check, true);
        List<Integer> lst = new ArrayList<>();

        check[1] = false;
        for(int i = 2 ; i * i <= M; i++){
            if(!check[i]) continue;
            for(int j = i * i ; j <= M ; j += i){
                check[j] = false;
            }
        }

        for(int i = N; i <= M ; i++){
            if(check[i]) lst.add(i);
        }

        for(int data : lst){
            System.out.println(data);
        }

    }
}
