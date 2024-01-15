package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_14430 {
    static class Loc{
        int x,y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] counts = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                counts[i][j] = -1;
            }
        }

        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(0,0));
        counts[0][0] = map[0][0];

        while(!q.isEmpty()){
            Loc loc = q.poll();
            if(loc.x == N-1 && loc.y == M-1){
                continue;
            }else{
                for(int i = 0 ; i < 2 ; i++){
                    int nx = loc.x + dx[i];
                    int ny = loc.y + dy[i];
                    if(nx >= 0 && ny >= 0 && nx < N && ny < M && counts[nx][ny] < counts[loc.x][loc.y] + map[nx][ny]){
                        counts[nx][ny] = counts[loc.x][loc.y] + map[nx][ny];
                        q.offer(new Loc(nx,ny));
                    }
                }
            }
        }
        System.out.println(counts[N-1][M-1]);
    }
}
