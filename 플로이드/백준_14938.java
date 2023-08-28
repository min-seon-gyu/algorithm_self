package 플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int value = Integer.MAX_VALUE / 2;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][n+1];
        int[] item = new int[n+1];

        for(int i = 1 ; i <= n ; i++ ){
            Arrays.fill(map[i], value);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < r ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = c;
            map[b][a] = c;
        }

        for(int j = 1 ; j <= n ; j++){
            map[j][j] = 0;
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                for(int k = 1 ; k <= n ; k++){
                    if(map[j][k] > map[j][i] + map[i][k]){
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }

        int answer = 0;
        for(int j = 1 ; j <= n ; j++){
            int sum = item[j];
            for(int k = 1 ; k <= n ; k++){
                if(j == k) continue;
                if(map[j][k] <= m ) sum += item[k];
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}
