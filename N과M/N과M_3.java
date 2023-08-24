package N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_3 {
    static int N;
    static int M;
    static int[] arr;
    static int[] ans;
    static int[] check;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        ans = new int[M];
        check = new int[N];

        for(int i = 0; i < N ; i++ ){
            arr[i] = i+1;
        }
        go(0,0);
        System.out.println(sb);
    }

    private static void go(int idx, int count) {
        if(count == M){
            for(int i : ans) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N ; i++){
            if(check[i] < M){
                check[i]++;
                ans[count] = arr[i];
                go(i+1, count + 1);
                check[i]--;
            }
        }
    }
}
