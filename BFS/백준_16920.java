package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_16920 {
    public static class Loc{
        int x,y,dis;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Loc(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[] size;
    static char[][] map;
    static int N,M;
    static Queue<Loc> q = new LinkedList<>();

    static List<Loc>[] lst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        size = new int[P+1];
        lst = new List[P+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= P ; i++){
            size[i] = Integer.parseInt(st.nextToken());
            lst[i] = new ArrayList<>();
        }


        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = str.charAt(j);
                if(Character.isDigit(map[i][j])){
                    lst[map[i][j] - '0'].add(new Loc(i, j));
                }
            }
        }

        int idx = 1;
        while(true){
            dfs(idx++);

            if(idx > P) idx = 1;

            boolean check = false;
            for(int i = 1 ; i < lst.length ; i++){
                if(lst[i].size() > 0){
                    check = true;
                    break;
                }
            }

            if(!check) break;
        }

        int[] answer = new int[P+1];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(Character.isDigit(map[i][j])){
                    answer[map[i][j] - '0']++;
                }

            }
        }
        for(int i = 1 ; i < answer.length ; i++){
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static void dfs(int number) {
        Queue<Loc> q = new LinkedList<>();

        for(Loc l : lst[number]){
            q.offer(new Loc(l.x, l.y, 0));
        }

        lst[number].clear();

        while(!q.isEmpty()){
            Loc loc = q.poll();
            int x = loc.x;
            int y = loc.y;

            if(loc.dis == size[map[x][y] - '0']) {
                lst[number].add(new Loc(x, y));
                continue;
            }

            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == '.' && loc.dis <= size[map[x][y] - '0']){
                    map[nx][ny] = (char)('0' + number);
                    q.offer(new Loc(nx, ny, loc.dis + 1));
                }
            }
        }
    }
}
