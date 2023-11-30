package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_16931 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[] dz = {1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int max = 0;


        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        int[][][] map2 = new int[max][N][M];


        for(int i = 0 ; i < max ; i++){
            for(int j = 0 ; j < N ; j++){
                for(int k = 0 ; k < M ; k++){
                    if(map[j][k] > i) map2[i][j][k] = 1;
                }
            }
        }

        int answer = 0;

        for(int i = 0 ; i < max ; i++){
            for(int j = 0 ; j < N ; j++){
                for(int k = 0 ; k < M ; k++){
                    if(map2[i][j][k] == 0) continue;
                    for(int l = 0 ; l < 4 ; l++){
                        int nx = j + dx[l];
                        int ny = k + dy[l];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= M || map2[i][nx][ny] == 0) answer++;
                    }
                    for(int l = 0 ; l < 2 ; l++){
                        int nz = i + dz[l];
                        if(nz < 0 || nz >= max || map2[nz][j][k] == 0) answer++;
                    }
                }
            }
        }

        System.out.println(answer);


    }
}
