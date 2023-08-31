package 플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_17182 {
    public static int[][] map;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                for(int k = 0 ; k < N ; k++){
                    if(map[j][k] > map[j][i] + map[i][k]){
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }

        ArrayList<Integer> lst = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            if(i != K) lst.add(i);
        }

        int[] ints = lst.stream().mapToInt(i -> i).toArray();
        int[] ans = new int[N-1];
        boolean[] check = new boolean[N-1];
        int count = N - 1;

        comb(ints , ans, check, count, 0, K);

        System.out.println(answer);

    }
    public static void comb(int[] arr, int[] ans, boolean[] check, int total, int count, int start){

        if(count == total){
            int sum = 0;
            for(int i = 0 ; i < ans.length ; i++){
                sum += map[start][ans[i]];
                start = ans[i];
            }
            answer = Math.min(answer, sum);
        }


        for(int i = 0 ; i < total ; i++){
            if(!check[i]){
                check[i] = true;
                ans[count] = arr[i];
                comb(arr, ans, check, total, count + 1, start);
                check[i] = false;
            }
        }

    }
}
