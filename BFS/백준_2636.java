package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class 백준_2636 {
    public static class Wind{
        int x,y;

        public Wind(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static List<Wind> lst = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int count = 0;
        int answer = 0;
        int lastCount = 0;

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1){
                    count++;
                }
            }
        }

        while(count > 0){
            lastCount = count;
            boolean[][] visited = new boolean[N][M];
            dfs(N, M, 0, 0, map, visited);
            for(Wind w : lst){
                map[w.x][w.y] = 0;
            }
            count = count(map);
            answer++;
        }
        System.out.println(answer);
        System.out.println(lastCount);
    }
    public static void dfs(int N, int M, int x, int y, int[][] map, boolean[][] visited){
        if(map[x][y] == 1){
            lst.add(new Wind(x,y));
            return;
        }

        for(int j = 0 ; j < 4 ; j++){
            int nx = x + dx[j];
            int ny = y + dy[j];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(N, M, nx, ny, map, visited);
            }
        }
    }

    public static int count(int[][] map){
        int count = 0;
        for(int i = 0 ; i < map.length ; i++){
            for(int j = 0 ; j < map[i].length ; j++){
                if(map[i][j] == 1) count++;
            }
        }
        return count;
    }
}
