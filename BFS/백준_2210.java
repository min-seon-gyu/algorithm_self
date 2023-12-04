package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 백준_2210 {
    static HashSet<String> hs = new HashSet<>();
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static String[][] map = new String[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 5 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 5 ; j++){
                map[i][j] = st.nextToken();
            }
        }

        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                dfs(i,j,map[i][j]);
            }
        }

        System.out.println(hs.size());
    }

    private static void dfs(int i, int j, String s) {
        if(s.length() == 6){
            hs.add(s);
            return;
        }

        for(int k = 0 ; k < 4 ; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5){
                dfs(nx, ny, s+map[nx][ny]);
            }
        }

    }
}
