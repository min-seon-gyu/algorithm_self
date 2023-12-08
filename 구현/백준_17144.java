package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_17144 {
    public static class Dust{
        int x,y,a;

        public Dust(int x, int y, int a) {
            this.x = x;
            this.y = y;
            this.a = a;
        }
    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        ArrayDeque<Dust> q = new ArrayDeque<>();
        int total = 2;
        int upX = 0;
        int downX = 0;

        for(int i = 0 ; i < R ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < C ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] > 4) q.offer(new Dust(i,j,map[i][j]));

                if(map[i][j] == -1 && upX == 0) upX = i;
                else if(map[i][j] == -1 && downX == 0) downX = i;

                total += map[i][j];
            }
        }

        for(int i = 0 ; i < T ; i++){
            //확산
            while(!q.isEmpty()){
                Dust dust = q.poll();
                int cnt = 0;
                for(int k = 0 ; k < 4 ; k++){
                    int nx = dust.x + dx[k];
                    int ny = dust.y + dy[k];
                    if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1){
                        cnt++;
                        map[nx][ny] += (dust.a / 5);
                    }
                }
                map[dust.x][dust.y] -= (dust.a / 5 * cnt);
            }

            //위 공기청정기 실행
            total -= map[upX-1][0];
            for(int j = upX-1 ; j > 0; j--){
                map[j][0] = map[j-1][0];
            }
            for(int j = 0 ; j < C-1 ; j++){
                map[0][j] = map[0][j+1];
            }
            for(int j = 0 ; j < upX ; j++){
                map[j][C-1] = map[j+1][C-1];
            }
            for(int j = C-1 ; j > 1 ; j--){
                map[upX][j] = map[upX][j-1];
            }
            map[upX][1] = 0;

            //아래 공기청정기 실행
            total -= map[downX+1][0];
            for(int j = downX+1 ; j < R-1 ; j++){
                map[j][0] = map[j+1][0];
            }
            for(int j = 0 ; j < C-1 ; j++){
                map[R-1][j] = map[R-1][j+1];
            }
            for(int j = R-1 ; j > downX ; j--){
                map[j][C-1] = map[j-1][C-1];
            }
            for(int j = C-1 ; j > 1 ; j--){
                map[downX][j] = map[downX][j-1];
            }
            map[downX][1] = 0;

            for(int j = 0 ; j < R ; j++){
                for(int k = 0 ; k < C ; k++){
                    if(map[j][k] > 4) q.offer(new Dust(j,k,map[j][k]));
                }
            }
        }
        System.out.println(total);
    }
}
