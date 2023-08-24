package N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_2 {
    static int N;
    static int M;
    static int[] arr;
    static int[] ans;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        ans = new int[M];
        check = new boolean[N];

        for(int i = 0; i < N ; i++ ){
            arr[i] = i+1;
        }

        go(0,0);




    }

    private static void go(int a, int count) {
        if(count == M){
            for(int i : ans) System.out.print(i + " ");
            System.out.println();
            return;
        }

        for(int i = a; i < N ; i++){
            if(!check[i]){
                check[i] = true;
                ans[count] = arr[i];
                go(i+1, count + 1);
                check[i] = false;
            }
        }

    }
}
