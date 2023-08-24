package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_11403 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int V = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[V];

        for(int i = 0; i < V ; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < V ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < V ; j++){
                int value = Integer.parseInt(st.nextToken());
                if(value == 1){
                    arr[i].add(j);
                }
            }
        }

        int[][] answer = new int[V][V];

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < V ; i++){
            boolean[] visit = new boolean[V];
            q.offer(i);
            while(!q.isEmpty()){
                Integer poll = q.poll();
                for(int value : arr[poll]){
                    if(!visit[value]){
                        visit[value] = true;
                        q.offer(value);
                    }
                }

            }
            for(int j = 0 ; j < V ; j++){
                if(visit[j]){
                    answer[i][j] = 1;
                }
            }
        }

        for(int i = 0 ; i < V ; i++){
            for(int j = 0 ; j < V ; j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
