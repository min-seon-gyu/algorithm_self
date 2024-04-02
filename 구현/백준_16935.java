package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_16935 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        map = new int[N][M];


        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < R ; i++){
            int type = Integer.parseInt(st.nextToken());
            cal(type);
        }

        for(int i = 0 ; i < map.length ; i++){
            for(int j = 0 ; j < map[i].length ; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void cal(int type) {
        if(type == 1){
            int[][] temp = new int[map.length][map[0].length];
            for(int i = 0 ; i < map.length ; i++){
                for(int j = 0 ; j < map[i].length ; j++){
                    temp[i][j] = map[map.length-1-i][j];
                }
            }
            map = temp;
        }
        else if(type == 2){
            int[][] temp = new int[map.length][map[0].length];
            for(int i = 0 ; i < map.length ; i++){
                for(int j = 0 ; j < map[i].length ; j++){
                    temp[i][j] = map[i][map[i].length-1-j];
                }
            }
            map = temp;
        }

        else if(type == 3){
            int[][] temp = new int[map[0].length][map.length];
            for(int i = 0 ; i < map[0].length ; i++){
                for(int j = 0 ; j < map.length ; j++){
                    temp[i][j] = map[map.length-1-j][i];
                }
            }
            map = temp;
        }

        else if(type == 4){
            int[][] temp = new int[map[0].length][map.length];
            for(int i = 0 ; i < map[0].length ; i++){
                for(int j = 0 ; j < map.length ; j++){
                    temp[i][j] = map[j][map[0].length - 1 - i];
                }
            }
            map = temp;
        }
        else if(type == 5){
            int[][] temp = new int[map.length][map[0].length];
            int a = map.length/2;
            int b = map[0].length/2;

            //1
            for(int i = 0 ; i < a ; i++) {
                for (int j = 0; j < b; j++) {
                    temp[i][j] = map[i + a][j];
                }
            }

            //2
            for(int i = 0 ; i < a ; i++){
                for(int j = b ; j < map[0].length ; j++){
                    temp[i][j] = map[i][j - b];
                }
            }

            //3
            for(int i = a ; i < map.length ; i++){
                for(int j = b ; j < map[0].length ; j++){
                    temp[i][j] = map[i - a][j];
                }
            }

            //4
            for(int i = a ; i < map.length ; i++){
                for(int j = 0 ; j < b ; j++){
                    temp[i][j] = map[i][j + b];
                }
            }
            map = temp;
        }
        else if(type == 6){
            int[][] temp = new int[map.length][map[0].length];
            int a = map.length/2;
            int b = map[0].length/2;

            //1
            for(int i = 0 ; i < a ; i++) {
                for (int j = 0; j < b; j++) {
                    temp[i][j] = map[i][j + b];
                }
            }

            //2
            for(int i = 0 ; i < a ; i++){
                for(int j = b ; j < map[0].length ; j++){
                    temp[i][j] = map[i + a][j];
                }
            }

            //3
            for(int i = a ; i < map.length ; i++){
                for(int j = b ; j < map[0].length ; j++){
                    temp[i][j] = map[i][j - b];
                }
            }

            //4
            for(int i = a ; i < map.length ; i++){
                for(int j = 0 ; j < b ; j++){
                    temp[i][j] = map[i - a][j];
                }
            }


            map = temp;
        }
    }
}
