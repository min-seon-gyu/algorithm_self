package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2629 {
    static int N;
    static boolean[][] checked = new boolean[31][40001];
    static int[] weightArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        weightArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            weightArr[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            if(checked[N][Integer.parseInt(st.nextToken())]){
                sb.append("Y ");
            }else{
                sb.append("N ");
            }
        }
        System.out.println(sb.toString());
    }

    private static void solve(int idx, int weight) {

        if(checked[idx][weight]){
            return;
        }
        checked[idx][weight] = true;

        if(idx >= N) return;

        solve(idx + 1 , weight);
        solve(idx + 1 , weight + weightArr[idx]);
        solve(idx + 1 , Math.abs(weight - weightArr[idx]));
    }
}
