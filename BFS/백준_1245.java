package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1245 {
    public static class Loc{
        int x,y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<Loc> q = new LinkedList<>();
        int answer = 0;

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(!visited[i][j]){
                    boolean flag = true;
                    q.offer(new Loc(i,j));
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        Loc loc = q.poll();
                        for(int k = 0 ; k < 8 ; k++){
                            int nx = loc.x + dx[k];
                            int ny = loc.y + dy[k];
                            if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                                if(map[nx][ny] == map[i][j] && !visited[nx][ny]){
                                    visited[nx][ny] = true;
                                    q.offer(new Loc(nx,ny));
                                }else if(map[nx][ny] > map[i][j]){
                                    flag = false;
                                }
                            }
                        }
                    }
                    if(flag) answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
