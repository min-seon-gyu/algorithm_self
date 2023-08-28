package 플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_11780 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int value = Integer.MAX_VALUE / 2;
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][N+1];
        int[][] check = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i++){
            Arrays.fill(map[i], value);
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[s][e] = Math.min(map[s][e], c);
            check[s][e] = e;
        }

        for(int i = 1; i <= N ; i++){
            map[i][i] = 0;
        }

        for(int i = 1; i <= N ; i++){
            for(int j = 1; j <= N ; j++){
                for(int k = 1; k <= N ; k++){
                    if(j == k) continue;
                    if(map[j][k] > map[j][i] + map[i][k]){
                        map[j][k] = map[j][i] + map[i][k];
                        check[j][k] = check[j][i];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N ; i++){
            for(int j = 1; j <= N ; j++){
                if(map[i][j] == value){
                    sb.append(0 + " ");
                }else{
                    sb.append(map[i][j] + " ");
                }
            }
            sb.append("\n");
        }


        for(int i = 1; i <= N ; i++){
            for(int j = 1; j <= N ; j++){
                StringBuilder sb1 = new StringBuilder();
                if(check[i][j] == 0){
                    sb.append(0 + " ");
                }else{
                    int count = 1;
                    sb1.append(i + " ");
                    int idx = check[i][j];
                    while(true){
                        count++;
                        sb1.append(idx + " ");
                        if(idx == j) break;
                        idx = check[idx][j];
                    }
                    sb.append(count + " ").append(sb1 + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
