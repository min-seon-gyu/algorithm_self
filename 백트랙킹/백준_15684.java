package 백트랙킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_15684 {
    static int[][] map;
    static int N;
    static int M;
    static int H;

    static boolean end = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H+1][N+1];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[a][b+1] = 2;
        }


        for(int i = 0 ; i <= 3 ; i++){
            dfs(1,1,0,i);
            if(end){
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }

    public static void dfs(int s, int e, int count, int total){
        if(end) return;
        if(total == count){
            if(check()){
                end = true;
            }
            return;
        }

        if(e == N){
            s++;
            e = 0;
        }

        for(int i = s ; i < H + 1 ; i++){
            for(int j = e ; j < N; j++){
                if(map[i][j] == 0 && map[i][j+1] == 0){
                    map[i][j] = 1;
                    map[i][j+1] = 2;
                    dfs(i,j+1,count  + 1, total);
                    map[i][j] = 0;
                    map[i][j+1] = 0;
                }
            }
            e = 0;
        }
    }

    public static boolean check(){
        for(int i = 1 ; i < N + 1 ; i++){
            int end = i;
            for(int j = 1 ; j < H + 1 ; j++){
                if(map[j][end] == 1){
                    end++;
                }else if(map[j][end] == 2){
                    end--;
                }
            }
            if(i != end){
                return false;
            }
        }
        return true;
    }
}
