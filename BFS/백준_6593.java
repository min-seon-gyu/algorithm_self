package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_6593 {
    static class Loc{
        int x,y,h,s;

        public Loc(int h, int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.s = s;
        }
    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[] dh = {1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0){
                break;
            }

            char[][][] building = new char[L][R][C];
            boolean[][][] visited = new boolean[L][R][C];

            Queue<Loc> q = new LinkedList<>();

            int endX = 0;
            int endY = 0;
            int endH = 0;

            for(int i = 0 ; i < L ; i++){
                for(int j = 0 ; j < R + 1 ; j++){
                    String str = br.readLine();
                    if(j == R) continue;
                    for(int k = 0 ; k < C ; k++){
                        building[i][j][k] = str.charAt(k);
                        if(building[i][j][k] == 'S'){
                            q.offer(new Loc(i,j,k,0));
                            visited[i][j][k] = true;
                        }
                        if(building[i][j][k] == 'E'){
                            endH = i;
                            endX = j;
                            endY = k;
                        }
                    }
                }
            }

            boolean flag = false;
            while(!q.isEmpty()){
                Loc loc = q.poll();

                if(loc.x == endX && loc.y == endY && loc.h == endH){
                    flag = true;
                    sb.append("Escaped in ").append(loc.s).append(" minute(s).").append("\n");
                    break;
                }

                for(int i = 0 ; i < 4 ; i++){
                    int nx = loc.x + dx[i];
                    int ny = loc.y + dy[i];
                    if(nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[loc.h][nx][ny] && building[loc.h][nx][ny] != '#'){
                        visited[loc.h][nx][ny] = true;
                        q.offer(new Loc(loc.h, nx, ny, loc.s + 1));
                    }
                }

                for(int i = 0 ; i < 2; i++){
                    int nh = loc.h + dh[i];
                    if(nh >= 0 && nh < L && !visited[nh][loc.x][loc.y] && building[nh][loc.x][loc.y] != '#'){
                        visited[nh][loc.x][loc.y] = true;
                        q.offer(new Loc(nh, loc.x, loc.y, loc.s + 1));
                    }
                }
            }

            if(!flag){
                sb.append("Trapped!").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
