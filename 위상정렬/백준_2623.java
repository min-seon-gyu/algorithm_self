package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2623 {

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
            String[] str = br.readLine().split("\\s");
            int total = Integer.parseInt(str[0]);
            for(int j = 1 ; j < total ; j++){
                int V1 = Integer.parseInt(str[j]);
                int V2 = Integer.parseInt(str[j+1]);
                lst[V1].add(V2);
                arr[V2]++;
            }
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
        }else{
            System.out.println(0);
        }
    }
}
