package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int[] visited = new int[V+1];

            ArrayList<Integer>[] arr = new ArrayList[V+1];

            for(int j = 1 ; j <= V ; j++ ){
                arr[j] = new ArrayList<>();
            }


            for(int j = 0 ; j < E ; j++ ){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                arr[v1].add(v2);
                arr[v2].add(v1);
            }

            Queue<Integer> q = new LinkedList<>();
            boolean success = true;

            for(int j = 1 ; j <= V ; j++){
                if(visited[j] == 0){
                    q.offer(j);
                    visited[j] = 1;
                    while(!q.isEmpty()){
                        int idx = q.poll();
                        for(int value : arr[idx]){
                            if(visited[value] == 0){
                                q.offer(value);
                                visited[value] = visited[idx] * -1;
                            }
                            if(visited[idx] == visited[value]){
                                success = false;
                                break;
                            }
                        }
                    }
                    if(!success) break;
                }
            }
            if(success){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}
