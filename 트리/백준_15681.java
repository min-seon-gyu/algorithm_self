package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_15681 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[N+1];
        ArrayList<Integer>[] c = new ArrayList[N+1];
        ArrayList<Integer>[] arr = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++){
            arr[i] = new ArrayList<>();
            c[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < N - 1 ; i++){
            st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());

            arr[V1].add(V2);
            arr[V2].add(V1);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(R);
        check[R] = true;
        while(!q.isEmpty()){
            Integer poll = q.poll();
            for(int value : arr[poll]){
                if(!check[value]){
                    check[value] = true;
                    c[poll].add(value);
                    q.offer(value);
                }
            }
        }

        int[] answer = new int[N+1];
        dp(answer, c, R);

        String str = "asd";
        str.equals("123");




        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q ; i++){
            int idx = Integer.parseInt(br.readLine());
            sb.append(answer[idx]).append("\n");
        }
        System.out.println(sb);
    }

    private static int dp(int[] answer, ArrayList<Integer>[] c, int r) {

        if(c[r].size() == 0){
            answer[r] = 1;
            return 1;
        }

        for(int value : c[r]){
            answer[r] += dp(answer, c, value);
        }
        answer[r]++;
        return answer[r];
    }
}
