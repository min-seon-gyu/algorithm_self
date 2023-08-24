package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_5567 {

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

        int[] visit = new int[V+1];
        Arrays.fill(visit, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visit[1] = 0;

        while(!q.isEmpty()){
            int poll = q.poll();
            for(int idx : arr[poll]){
                if(visit[idx] == Integer.MAX_VALUE){
                    visit[idx] = visit[poll] + 1;
                    q.offer(idx);
                }
            }
        }
        int answer = -1;
        for(int i : visit){
            if(i <= 2){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
