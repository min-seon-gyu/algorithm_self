package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_17142 {
    public static class Loc{
        int x,y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int answer = Integer.MAX_VALUE;
    static int N, M;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static List<Loc> lst = new ArrayList<>();
    static List<Loc> target = new ArrayList<>();
    static int[][] map, status;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        status = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    lst.add(new Loc(i,j));
                    status[i][j] = 1;
                }
            }
        }

        comb(0, 0, M);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void comb(int idx, int count, int m) {
        if(count == m){
            bfs();
            return;
        }

        for(int i = idx ; i < lst.size() ; i++){
            target.add(lst.get(i));
            status[lst.get(i).x][lst.get(i).y] = 0;
            comb(i + 1, count + 1, m);
            target.remove(lst.get(i));
            status[lst.get(i).x][lst.get(i).y] = 1;
        }
    }

    private static void bfs() {
        Queue<Loc> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int[][] times = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            Arrays.fill(times[i], -1);
        }

        for (Loc loc : target) {
            q.offer(loc);
            visited[loc.x][loc.y] = true;
            times[loc.x][loc.y] = 0;
        }

        while(!q.isEmpty()){
            Loc loc = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nx = dx[i] + loc.x;
                int ny = dy[i] + loc.y;
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] != 1){
                    //출발지가 비활성 바이러스일 경우
                    if(status[loc.x][loc.y] == 1){
                        //목적지가 비활성 바이러스일 경우
                        if(status[nx][ny] == 1){
                            times[nx][ny] = times[loc.x][loc.y] - 1;
                        }
                        //목적지가 비활성 바이러스일 아닐경우
                        else{
                            times[nx][ny] = Math.abs(times[loc.x][loc.y]) + 1;
                        }
                    }
                    //출발지가 비활성 바이러스가 아닐 경우
                    else{
                        //목적지가 비활성 바이러스일 경우
                        if(status[nx][ny] == 1){
                            times[nx][ny] = -times[loc.x][loc.y] -1;
                        }
                        //목적지가 비활성 바이러스일 아닐경우
                        else{
                            times[nx][ny] = times[loc.x][loc.y] + 1;
                        }
                    }
                    times[nx][ny] = times[loc.x][loc.y] + 1;
                    visited[nx][ny] = true;
                    q.offer(new Loc(nx, ny));
                }
            }
        }
        int result = check(times);
        if(result >= 0) answer = Math.min(result, answer);
    }

    //마지막 하나만 남았는데 그 하나가 비활성된 바이러스일 경우 이 전에 시간이 전체가 감염되는 시간이다.

    private static int check(int[][] times) {
        int time = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(times[i][j] < 0 && map[i][j] != 1 && status[i][j] != 1) return -1;
                time = Math.max(time, times[i][j]);
            }
        }
        return time;
    }
}
