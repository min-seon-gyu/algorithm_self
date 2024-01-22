package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_17836 {
    static class Loc{
        int x,y,t,g;


        public Loc(int x, int y, int t, int g) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.g = g;
        }
    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Loc> pq = new LinkedList<>();
        pq.offer(new Loc(0,0,0,0));
        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;


        while(!pq.isEmpty()){
            Loc poll = pq.poll();

            if(poll.x == N-1 && poll.y == M-1){
                System.out.println(poll.t);
                return;
            }

            if(poll.t > T){
                System.out.println("Fail");
                return;
            }

            for(int i = 0 ; i < 4 ; i++){
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny][poll.g]){
                    if(map[nx][ny] == 0){
                        pq.offer(new Loc(nx, ny, poll.t + 1, poll.g));
                        visited[nx][ny][poll.g] = true;
                    }else if(map[nx][ny] == 1 && poll.g == 1){
                        pq.offer(new Loc(nx, ny, poll.t + 1, poll.g));
                        visited[nx][ny][poll.g] = true;
                    }else if(map[nx][ny] == 2){
                        pq.offer(new Loc(nx, ny, poll.t + 1, 1));
                        visited[nx][ny][0] = true;
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        System.out.println("Fail");
    }
}
