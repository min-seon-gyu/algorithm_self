package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_13565 {
    public static class Loc{
        int x,y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];

        for(int i = 0 ; i < M ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        boolean[][] visited = new boolean[M][N];
        Queue<Loc> q = new LinkedList<>();

        for(int i = 0 ; i < N ; i++){
            if(!visited[0][i] && map[0][i] == 0){
                visited[0][i] = true;
                q.offer(new Loc(0,i));
                while(!q.isEmpty()){
                    Loc loc = q.poll();
                    for(int j = 0 ; j < 4 ; j++){
                        int nx = loc.x + dx[j];
                        int ny = loc.y + dy[j];
                        if(nx >= 0 && nx < M && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 0){
                            if(nx == M-1){
                                System.out.println("YES");
                                return;
                            }
                            visited[nx][ny] = true;
                            q.offer(new Loc(nx,ny));
                        }
                    }
                }
            }
        }
        System.out.println("NO");
    }
}
