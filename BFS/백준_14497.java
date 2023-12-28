package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_14497 {
    public static class Loc{
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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;

        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = str.charAt(j);
            }
        }

        ArrayDeque<Loc> q = new ArrayDeque<>();
        q.offer(new Loc(x1,y1,0));

        visited[x1][y1] = true;

        while(!q.isEmpty()){
            Loc loc = q.poll();
            if(loc.x == x2 && loc.y == y2){
                System.out.println(loc.c + 1);
                return;
            }
            for(int i = 0 ; i < 4 ; i++){
                int nx = loc.x + dx[i];
                int ny = loc.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if (visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    if (map[nx][ny] == '1') {
                        q.offerLast(new Loc(nx, ny, loc.c+1));
                    } else {
                        q.offerFirst(new Loc(nx, ny, loc.c));
                    }
                }
            }
        }
    }
}
