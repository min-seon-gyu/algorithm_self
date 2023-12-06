package BFS;

import javax.swing.plaf.BorderUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_16174 {
    public static class J{
        int x,y;

        public J(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static boolean[][] visited;
    static int N;
    static int[][] map;
    static Queue<J> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        q.offer(new J(0,0));

        while(!q.isEmpty()){
            J j = q.poll();
            if(j.x == N-1 && j.y == N-1){
                System.out.println("HaruHaru");
                return;
            }

            int nx = j.x + map[j.x][j.y];
            int ny = j.y + map[j.x][j.y];

            if(check(nx,j.y) && !visited[nx][j.y]){
                visited[nx][j.y] = true;
                q.offer(new J(nx,j.y));
            }

            if(check(j.x,ny) && !visited[j.x][ny]){
                visited[j.x][ny] = true;
                q.offer(new J(j.x,ny));
            }

            //next(j.x,j.y,map[j.x][j.y],0);
        }

        System.out.println("Hing");
    }

    public static void next(int x, int y, int d, int n){
        if(n==d){
            if(!visited[x][y]){
                q.offer(new J(x,y));
                visited[x][y] = true;
                return;
            }
        }

        for(int i = 0 ; i < 2 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(check(nx,ny)){
                next(nx,ny,d,n+1);
            }

        }
    }

    public static boolean check(int x, int y){
        if(x >= 0 && y >= 0 && x < N && y < N){
            return true;
        }
        return false;
    }
}
