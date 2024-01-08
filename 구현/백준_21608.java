package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_21608 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        int[][] map = new int[N+1][N+1];

        for(int i = 0 ; i < N * N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j = 0 ; j < 4 ; j++){
                arr.add(Integer.parseInt(st.nextToken()));
            }
            hm.put(number, arr);

            boolean flag = false;
            int t_count = 0;
            int z_count = -1;
            int px = 0;
            int py = 0;

            for(int j = 1; j <= N ; j++){
                if(flag) break;
                for(int k = 1 ; k <= N ; k++){
                    if(flag) break;

                    if(map[j][k] != 0) continue;


                    int targetCount = 0;
                    int zeroCount = 0;
                    for(int l = 0 ; l < 4; l++){
                        int nx = j + dx[l];
                        int ny = k + dy[l];
                        if(nx > 0 && nx <= N && ny > 0 && ny <= N){
                            if(arr.contains(map[nx][ny])) targetCount++;
                            if(map[nx][ny] == 0) zeroCount++;
                        }
                    }
                    if(targetCount == 4){
                        map[j][k] = number;
                        flag = true;
                    }else if(targetCount > t_count){
                        t_count = targetCount;
                        z_count = zeroCount;
                        px = j;
                        py = k;
                    }else if(targetCount == t_count && zeroCount > z_count){
                        z_count = zeroCount;
                        px = j;
                        py = k;
                    }
                }
            }
            if(flag) continue;

            map[px][py] = number;
        }



        for(int i = 1; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                int value = map[i][j];
                int count = 0;
                List<Integer> integers = hm.get(value);
                for(int k = 0 ; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx > 0 && nx <= N && ny > 0 && ny <= N){
                        if(integers.contains(map[nx][ny])) count++;
                    }
                }
                if(count == 1){
                    answer += 1;
                }else if(count == 2){
                    answer += 10;
                }else if(count == 3){
                    answer += 100;
                }else if(count == 4){
                    answer += 1000;
                }
            }
        }

        System.out.println(answer);
    }
}
