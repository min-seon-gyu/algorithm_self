package 백트랙킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_13023 {
    static ArrayList<Integer>[] arr;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];

        for(int i = 0 ; i < N ; i++) arr[i] = new ArrayList<>();

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        // max 2000
        for(int i = 0 ; i < N ; i++){
            boolean[] visited =  new boolean[N];
            visited[i] = true;
            dfs(i, visited, 1);
        }

        if(flag) System.out.println(1);
        else System.out.println(0);
    }

    private static void dfs(int i, boolean[] visited, int depth) {
        if(flag || depth == 5){
            flag = true;
            return;
        }

        for(int next : arr[i]){
            if(!visited[next]){
                visited[next] = true;
                dfs(next, visited, depth + 1);
                visited[next] = false;
            }
        }
    }
}
