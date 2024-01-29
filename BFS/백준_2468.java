package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2468 {
    static class Loc{
        int x,y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int height = 0;

        for(int i = 0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, map[i][j]);
            }
        }

        int answer = 0;
        Queue<Loc> q = new LinkedList<>();
        for(int i = 0 ; i < height ; i++){
            boolean[][] visited = new boolean[N][N];
            int count = 0;
            for(int j = 0; j < N ; j++){
                for(int k = 0 ; k < N ; k++){
                    if(map[j][k] > i && !visited[j][k]){
                        visited[j][k] = true;
                        q.offer(new Loc(j,k));
                        count++;
                        while(!q.isEmpty()){
                            Loc loc = q.poll();
                            for(int l = 0 ; l < 4 ; l++){
                                int nx = loc.x + dx[l];
                                int ny = loc.y + dy[l];
                                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] > i){
                                    q.offer(new Loc(nx,ny));
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }

                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}
