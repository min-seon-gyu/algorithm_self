package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T ; i++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] values = new int[N];
            for(int j = 0 ; j < N ; j++){
                values[j] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            long max = values[N-1];

            for(int j = N - 2; j >= 0 ; j--){
                if(values[j] < max){
                    answer += max - values[j];
                }else{
                    max = values[j];
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
