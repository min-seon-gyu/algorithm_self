package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2606 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] arr = new ArrayList[V+1];

        for(int i = 1; i <= V ; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < E ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());

            arr[V1].add(V2);
            arr[V2].add(V1);
        }

        int answer = 0;
        boolean[] visit = new boolean[V+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visit[1] = true;

        while(!q.isEmpty()){

            Integer poll = q.poll();

            for(int idx : arr[poll]){
                if(!visit[idx]){
                    visit[idx] = true;
                    answer++;
                    q.offer(idx);
                }
            }
        }


        System.out.println(answer);
    }
}
