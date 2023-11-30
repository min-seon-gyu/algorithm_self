package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_20057 {
    static int[] percent = {10, 10, 7, 7, 5, 2, 2, 1, 1};
    static int[][] dx = {{-1, 1, -1, 1, 0, -2, 2, -1, 1},
                        {1, 1, 0, 0, 2, 0, 0, -1, -1},
                        {-1, 1, -1, 1, 0, -2, 2, -1, 1},
                        {-1, -1, 0, 0, -2, 0, 0, 1, 1}};
    static int[][] dy = {{-1, -1, 0, 0, -2, 0, 0, 1, 1},
                        {-1, 1, -1, 1, 0, -2, 2, -1, 1},
                        {1, 1, 0, 0, 2, 0, 0, -1, -1},
                        {-1, 1, -1, 1, 0, -2, 2, -1, 1}};

    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int total = 0;

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        int startX = N / 2;
        int startY = N / 2;


        int dirIdx = 0;
        int isPlus = 1;
        int dis = 1;

        while(true){
            boolean flag = false;

            for(int i = 0 ; i < dis ; i++){
                startX += dirX[dirIdx];
                startY += dirY[dirIdx];

                if(startX < 0 || startY < 0 || startX >= N || startY >= N){
                    flag = true;
                    break;
                }

                int sand = map[startX][startY];
                int sum = 0;

                if(sand < 10) {
                    if(startX + dirX[dirIdx] >= 0 && startY + dirY[dirIdx] >= 0 && startX + dirX[dirIdx] < N && startY + dirY[dirIdx] < N){
                        map[startX + dirX[dirIdx]][startY + dirY[dirIdx]] += sand;
                    }
                    map[startX][startY] = 0;
                    continue;
                }

                for(int j = 0 ; j < 9 ; j++){
                    int nx = startX + dx[dirIdx][j];
                    int ny = startY + dy[dirIdx][j];
                    int per = percent[j];

                    double moveSand = sand * (per / (double)100);
                    sum += (int)moveSand;
                    if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                        map[nx][ny] += (int)moveSand;
                    }
                }
                if(startX + dirX[dirIdx] >= 0 && startY + dirY[dirIdx] >= 0 && startX + dirX[dirIdx] < N && startY + dirY[dirIdx] < N){
                    map[startX + dirX[dirIdx]][startY + dirY[dirIdx]] += (sand - sum);
                }

                map[startX][startY] = 0;
            }
            if(flag) break;

            if(isPlus++ % 2 == 0) dis++;
            dirIdx = dirIdx + 1 > 3 ? 0 : dirIdx + 1;
        }


        int answer = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                answer += map[i][j];
            }
        }
        System.out.println(total-answer);
    }
}
