package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_9372 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < T ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for(int j = 0 ; j < M ; j++){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
            }
            sb.append(N-1).append("\n");

        }
        System.out.println(sb);
    }
}
