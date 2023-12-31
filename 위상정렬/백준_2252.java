package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2252 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        ArrayList<Integer>[] lst = new ArrayList[N+1];

        for(int i = 1 ; i <=N ; i++){
            lst[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());

            lst[V1].add(V2);
            arr[V2]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1 ; i <= N ; i++){
            if(arr[i] == 0) q.offer(i);
        }


        int count = 0;

        while(!q.isEmpty()){
            Integer poll = q.poll();
            sb.append(poll).append(" ");
            count++;
            for(int value : lst[poll]){
                arr[value]--;
                if(arr[value] == 0){
                    q.offer(value);
                }
            }
        }

        if(count == N){
            System.out.println(sb);
        }
    }
}
