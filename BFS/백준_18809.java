package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_18809 {

    public static class Loc{
        int x,y;

        public Loc(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int n,m,g,r;
    static boolean[] dfs_visited;
    static int[][] map;
    static List<Loc> dfs_list = new ArrayList<>();
    static List<Loc> green = new ArrayList<>();
    static List<Loc> red = new ArrayList<>();
    static int[][] green_time = new int[n][m];
    static int[][] red_time = new int[n][m];
    static boolean[][] green_visited = new boolean[n][m];
    static boolean[][] red_visited = new boolean[n][m];
    static int answer = 0;
    static int[][] copy_map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        g = Integer.parseInt(t[2]);
        r = Integer.parseInt(t[3]);

        map = new int[n][m];

        dfs_list = new ArrayList<>();
        green = new ArrayList<>();
        red = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            String[] tt = br.readLine().split(" ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = Integer.parseInt(tt[j]);
                if(map[i][j] == 2) dfs_list.add(new Loc(i, j));
            }
        }


        dfs_visited = new boolean[dfs_list.size()];
        green_dfs(0,0);
        System.out.println(answer);

    }

    private static void green_dfs(int start, int count) {
        if(count == g){
            green.clear();
            for(int i = 0 ; i < dfs_visited.length ; i++){
                if(dfs_visited[i]) green.add(dfs_list.get(i));
            }
            redC(0, 0);
            return;
        }


        for(int i = start ; i < dfs_visited.length ; i++){
            if(!dfs_visited[i]){
                dfs_visited[i] = true;
                green_dfs(start + 1,  count + 1);
                dfs_visited[i] = false;
            }
        }
    }

    private static void redC(int start, int count) {
        if(count == r){
            red.clear();
            for(int i = 0 ; i < dfs_visited.length ; i++){
                if(dfs_visited[i] && !green.contains(dfs_list.get(i))) red.add(dfs_list.get(i));
            }
            bfs();
            return;
        }


        for(int i = start ; i < dfs_visited.length ; i++){
            if(!dfs_visited[i]){
                dfs_visited[i] = true;
                redC(start + 1,  count + 1);
                dfs_visited[i] = false;
            }
        }
    }

    private static boolean check(int x, int y){
        if(x >= 0 && y >= 0 && x < n && y < m) return true;
        return false;
    }

    private static void copy(){
        copy_map = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                copy_map[i][j] = map[i][j];
            }
        }
    }

    public static void bfs() {
        int flower =0;
        green_visited = new boolean[n][m];
        green_time = new int[n][m];
        red_visited = new boolean[n][m];
        red_time = new int[n][m];

        copy();
        Queue<Loc>rq = new LinkedList<>();
        Queue<Loc>gq = new LinkedList<>();

        for(int i = 0; i< red.size(); i++) {
            rq.add(red.get(i));
            red_visited[red.get(i).x][red.get(i).y]=true;
        }
        for(int i = 0; i< green.size(); i++) {
            green_visited[green.get(i).x][green.get(i).y]=true;
            gq.add(green.get(i));
        }


        while(!rq.isEmpty() && !gq.isEmpty()) {
            if(!gq.isEmpty()) {
                int rep = gq.size();
                while(rep-- !=0) {
                    Loc a= gq.poll();
                    green_visited[a.x][a.y] = true;
                    if(copy_map[a.x][a.y]==3) {
                        continue;
                    }

                    for(int i=0; i<4; i++) {
                        int nx = a.x+dx[i];
                        int ny = a.y+dy[i];
                        if(check(nx,ny) && (copy_map[nx][ny]==1 || copy_map[nx][ny]==2) && !green_visited[nx][ny]) {
                            green_visited[nx][ny]=true;
                            green_time[nx][ny] = green_time[a.x][a.y]+1;
                            gq.add(new Loc(nx,ny));
                        }
                    }
                }
            }
            if(!rq.isEmpty()) {
                int rep = rq.size();
                while(rep-- !=0) {
                    Loc a = rq.poll();
                    red_visited[a.x][a.y] = true;

                    if(copy_map[a.x][a.y]==3) {
                        continue;
                    }
                    for(int i=0; i<4; i++) {
                        int nx = a.x+dx[i];
                        int ny = a.y+dy[i];
                        if(check(nx,ny) && (copy_map[nx][ny]==1 || copy_map[nx][ny]==2) && !red_visited[nx][ny]) {
                            red_visited[nx][ny] = true;
                            red_time[nx][ny] = red_time[a.x][a.y]+1;
                            if(red_time[nx][ny]==green_time[nx][ny]) {

                                flower++;
                                copy_map[nx][ny]=3;
                            }
                            else {
                                rq.add(new Loc(nx,ny));
                            }
                        }
                    }
                }
            }
        }
        answer = Math.max(answer, flower);
    }
}
