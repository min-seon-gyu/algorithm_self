package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_6087 {
    static class Loc{
        int x,y,c;

        public Loc(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int startCX = -1;
        int startCY = -1;
        int endCX = -1;
        int endCY = -1;

        char[][] map = new char[H][W];

        for(int i = 0 ; i < H ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < W ; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'C'){
                    if(startCX == -1 && startCY == -1){
                        startCX = i;
                        startCY = j;
                    }else{
                        endCX = i;
                        endCY = j;
                    }
                }
            }
        }

        Queue<Loc> pq = new LinkedList<>();
        pq.offer(new Loc(startCX, startCY, -1));
        int[][] visited = new int[H][W];
        for(int i = 0 ; i < H ; i++){
            Arrays.fill(visited[i], 100000);
        }
        visited[startCX][startCY] = -1;

        while(!pq.isEmpty()){
            Loc loc = pq.poll();
            if(loc.x == endCX && loc.y == endCY){
                System.out.println(loc.c);
                return;
            }

            for(int i = 0 ; i < 4 ; i++){
                int nx = dx[i] + loc.x;
                int ny = dy[i] + loc.y;
                while(true){
                    if(nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == '*') break;
                    if(visited[nx][ny] > visited[loc.x][loc.y] + 1){
                        visited[nx][ny] = visited[loc.x][loc.y] + 1;
                        pq.offer(new Loc(nx, ny, loc.c + 1));
                    }
                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }
    }
}
