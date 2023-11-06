import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TEST {
    static int countX = 0;
    static int countY = 0;
    static boolean[] checkX;
    static boolean[] checkY;
    static int[][] chess;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        chess = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                chess[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int number = 2 * N - 1;


        // x + y
        checkX = new boolean[number];
        // x - y + N - 1
        checkY = new boolean[number];

        black(0);
        white(0);

        System.out.println(countX + countY);
    }



    private static void black(int count) {
        countX = Math.max(count, countX);

        for(int i = 0 ; i < N ; i++){
            for(int j = i % 2 == 1 ? 0 : 1 ; j < N ; j = j + 2){
                if(chess[i][j] == 1 && !checkX[i+j] && !checkY[i-j+N-1]){
                    checkX[i+j] = true;
                    checkY[i-j+N-1] = true;

                    black(count + 1);

                    checkX[i+j] = false;
                    checkY[i-j+N-1] = false;
                }
            }
        }
    }
    private static void white(int count) {
        countY = Math.max(count, countY);

        for(int i = 0 ; i < N ; i++){
            for(int j = i % 2 == 1 ? 1 : 0 ; j < N ; j = j + 2){
                if(chess[i][j] == 1 && !checkX[i+j] && !checkY[i-j+N-1]){
                    checkX[i+j] = true;
                    checkY[i-j+N-1] = true;

                    white(count + 1);

                    checkX[i+j] = false;
                    checkY[i-j+N-1] = false;
                }
            }
        }
    }
}
