package 비트마스킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1194{
    public static class Loc{
        int x,y,dist,keys;

        public Loc(int x, int y, int dist, int keys) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.keys = keys;
        }
    }

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        boolean[][][] visited = new boolean[N][M][1 << 6];
        Queue<Loc> q = new LinkedList<>();

        for(int i = 0; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == '0'){
                    map[i][j] = '.';
                    q.offer(new Loc(i, j, 0, 0));
                    visited[i][j][0] = true;
                }
            }
        }

        while(!q.isEmpty()){

            Loc loc = q.poll();
            int x = loc.x;
            int y = loc.y;
            int dist = loc.dist;
            int keys = loc.keys;

            if(map[x][y] == '1'){
                System.out.println(dist);
                return;
            }

            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != '#' && !visited[nx][ny][keys]){
                    if(map[nx][ny] == '.' || map[nx][ny] == '1'){
                        q.offer(new Loc(nx, ny, dist + 1, keys));
                        visited[nx][ny][keys] = true;
                    }
                    else if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f'){
                        int newkey = keys | (1 << map[nx][ny] - 'a');
                        q.offer(new Loc(nx, ny, dist + 1, newkey));
                        visited[nx][ny][keys] = true;

                    }
                    else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F'){
                        if((keys & (1 << (map[nx][ny] - 'A'))) != 0){
                            q.offer(new Loc(nx, ny, dist + 1, keys));
                            visited[nx][ny][keys] = true;
                        }
                    }


                }
            }
        }

        System.out.println(-1);
    }
}
