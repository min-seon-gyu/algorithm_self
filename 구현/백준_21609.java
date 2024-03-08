package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_21609 {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] map;
    static int N,M,answer;
    static final int BLANK = -10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            Block block = find_group();
            if(block.x == -1 && block.y == -1){
                break;
            }
            remove_block(block.x, block.y);
            move_block();
            rotation_block();
            move_block();
        }

        System.out.println(answer);
    }

    private static void rotation_block() {
        int[][] tmp = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                tmp[i][j] = map[j][N-1-i];
            }
        }

        map = tmp;
    }

    private static void move_block() {
        for(int i = 0 ; i < N ; i++){
            for(int j = N-2 ; j >= 0 ; j--){
                if(map[j][i] < 0 ) continue;
                int targetIdx = -1;
                for(int k = j + 1 ; k < N ; k++){
                    if(map[k][i] == BLANK){
                        targetIdx = k;
                    }
                    if(map[k][i] == -1) break;
                }
                if(targetIdx != -1){
                    map[targetIdx][i] = map[j][i];
                    map[j][i] = BLANK;
                }
            }
        }
    }

    private static void remove_block(int x, int y) {
        int value = map[x][y];
        map[x][y] = BLANK;
        Queue<Block> q = new LinkedList<>();
        q.offer(new Block(x,y));
        while(!q.isEmpty()){
            Block block = q.poll();
            for(int k = 0 ; k < 4 ; k++){
                int nx = dx[k] + block.x;
                int ny = dy[k] + block.y;
                if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                    if(map[nx][ny] == value || map[nx][ny] == 0){
                        map[nx][ny] = BLANK;
                        q.offer(new Block(nx,ny));
                    }
                }
            }
        }

    }

    private static Block find_group() {
        int x = -1;
        int y = -1;
        int maxCnt = 0;
        int maxSize = 1;
        Queue<Block> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] <= 0 || visited[i][j]) continue;
                int cnt = 0;
                int size = 1;
                visited[i][j] = true;
                q.offer(new Block(i,j));
                while(!q.isEmpty()){
                    Block block = q.poll();
                    for(int k = 0 ; k < 4 ; k++){
                        int nx = dx[k] + block.x;
                        int ny = dy[k] + block.y;
                        if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]){
                            if(map[nx][ny] == map[i][j] || map[nx][ny] == 0){
                                size++;
                                if(map[nx][ny] == 0) cnt++;
                                visited[nx][ny] = true;
                                q.offer(new Block(nx,ny));
                            }
                        }
                    }
                }

                if(size > 1){
                    if(maxSize < size){
                        maxSize = size;
                        maxCnt = cnt;
                        x = i;
                        y = j;
                    }else if(maxSize == size && maxCnt <= cnt){
                        maxCnt = cnt;
                        x = i;
                        y = j;
                    }
                }
                reset_rainbow_visited(visited);
            }
        }
        if(maxSize != 1) answer += Math.pow(maxSize, 2);
        return new Block(x,y);
    }

    private static void reset_rainbow_visited(boolean[][] visited) {
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 0) visited[i][j] = false;
            }
        }
    }


    public static class Block{
        int x,y;

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
