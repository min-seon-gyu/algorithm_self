package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2146 {
    public static class Loc{
        int x,y,dis;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Loc(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] map2 = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        int idx = 0;

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    idx++;
                    Queue<Loc> q = new LinkedList<>();
                    q.offer(new Loc(i, j));
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        Loc loc = q.poll();
                        map2[loc.x][loc.y] = idx;
                        for(int k = 0 ; k < 4 ; k++){
                            int nx = loc.x + dx[k];
                            int ny = loc.y + dy[k];
                            if(nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 1 && !visited[nx][ny]){
                                q.offer(new Loc(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                System.out.print(map2[i][j] + " ");
            }
            System.out.println();
        }



        int answer = Integer.MAX_VALUE;

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map2[i][j] != 0){
                    idx = map2[i][j];
                    boolean[][] visited2 = new boolean[N][N];

                    visited2[i][j] = true;
                    Queue<Loc> q = new LinkedList<>();
                    q.offer(new Loc(i,j,0));

                    while(!q.isEmpty()){
                        Loc loc = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = loc.x + dx[k];
                            int ny = loc.y + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map2[nx][ny] != idx && !visited2[nx][ny]) {
                                q.offer(new Loc(nx, ny, loc.dis + 1));
                                visited2[nx][ny] = true;
                                if(map2[nx][ny] != 0){
                                    answer = Math.min(answer, loc.dis + 1);
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer-1);

    }
}
