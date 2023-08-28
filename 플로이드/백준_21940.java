package 플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_21940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int max = Integer.MAX_VALUE / 2;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];

        for(int i = 1 ; i<= N ;i++){
            Arrays.fill(map[i], max);
            map[i][i] = 0;
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            map[a][b] = t;
        }

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                for(int k = 1 ; k <= N ; k++){
                    if(map[j][k] > map[j][i] + map[i][k]){
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        ArrayList<Integer> lst = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K ; i++){
            lst.add(Integer.parseInt(st.nextToken()));
        }

        int[] answer = new int[N+1];
        for(int i = 1; i <= N ; i++){
            for(int j = 0; j < K ; j++){
                int idx = lst.get(j);
                answer[i] = Math.max(answer[i], map[i][idx] + map[idx][i]);
            }
        }

        lst = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        for(int i = 1 ; i <= N ; i++){
            if(minValue > answer[i]){
                minValue = answer[i];
                lst.clear();
                lst.add(i);
            }else if(minValue == answer[i]){
                lst.add(i);
            }
        }
StringBuilder sb = new StringBuilder();
        for(int data : lst){
            sb.append(data + " ");
        }
        System.out.println(sb);
    }
}
