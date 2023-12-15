package BFS;

import java.util.*;

public class 백준_16988 {
    static int N;
    static int M;
    static int[][] map;
    static int max = 0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        List<Loc> lst = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 0) lst.add(new Loc(i,j));
            }
        }

        for(int i = 0 ; i < lst.size(); i++){
            for(int j = i+1; j < lst.size(); j++){
                map[lst.get(i).x][lst.get(i).y] = 1;
                map[lst.get(j).x][lst.get(j).y] = 1;
                check();
                map[lst.get(i).x][lst.get(i).y] = 0;
                map[lst.get(j).x][lst.get(j).y] = 0;
            }
        }

        System.out.println(max);
    }

    private static void check() {

        int result = 0;
        boolean[][] visited = new boolean[N][M];
        Queue<Loc> q = new LinkedList<>();

        //400
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 2 && !visited[i][j]){
                    int count = 1;
                    boolean flag = false;
                    visited[i][j] = true;
                    q.offer(new Loc(i,j));
                    while(!q.isEmpty()){
                        Loc poll = q.poll();
                        for(int k = 0 ; k < 4 ; k++){
                            int nx = poll.x + dx[k];
                            int ny = poll.y + dy[k];
                            if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]){
                                if(map[nx][ny] == 2){
                                    visited[nx][ny] = true;
                                    q.offer(new Loc(nx, ny));
                                    count++;
                                }else if(map[nx][ny] == 0){
                                    flag = true;
                                }
                            }
                        }
                    }
                    if(!flag) {
                        result += count;
                    }
                }
            }
        }
        max = Math.max(result, max);
    }
    static class Loc{
        int x,y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
