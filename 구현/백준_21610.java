package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_21610 {
    static class Loc{
        int x,y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    //←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[][] map;
    static boolean[][] checked;
    static Queue<Loc> q = new LinkedList<>();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q.offer(new Loc(N, 1));
        q.offer(new Loc(N, 2));
        q.offer(new Loc(N-1, 1));
        q.offer(new Loc(N-1, 2));

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            // 1,2,3 과정
            moveAndAddWater(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            // 4  과정
            copyWater();
            // 5  과정
            addCloud();
        }
        System.out.println(sum());
    }

    private static int sum() {
        int sum = 0;
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                sum += map[i][j];
            }
        }
        return sum;
    }

    private static void addCloud() {
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                if(map[i][j] >= 2 && !checked[i][j]){
                    q.offer(new Loc(i,j));
                    map[i][j] -=2;
                }
            }
        }
    }

    private static void copyWater() {
        checked = new boolean[N+1][N+1];

        while(!q.isEmpty()){
            Loc loc = q.poll();
            checked[loc.x][loc.y] = true;

            int count = 0;
            for(int i = 2 ; i <= 8; i+=2){
                int nx = loc.x + dx[i];
                int ny = loc.y + dy[i];
                if(nx > 0 && nx <= N && ny > 0 && ny <= N && map[nx][ny] > 0){
                    count++;
                }
            }
            map[loc.x][loc.y] += count;
        }
    }

    private static void moveAndAddWater(int dir, int dist) {
        int size = q.size();
        for(int i = 0 ; i < size ; i++){
            Loc loc = q.poll();

            int count = dist;
            int nx = loc.x;
            int ny = loc.y;

            while(count-- > 0){
                nx += dx[dir];
                ny += dy[dir];

                if(nx > N) nx = 1;
                if(nx < 1) nx = N;
                if(ny > N) ny = 1;
                if(ny < 1) ny = N;
            }
            map[nx][ny]++;
            q.offer(new Loc(nx,ny));
        }
    }
}