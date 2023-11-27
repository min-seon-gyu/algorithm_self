package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2644 {
    public static class Node{
        int idx,value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());

        ArrayList<Integer>[] arr = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++){
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x].add(y);
            arr[y].add(x);
        }

        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        visited[s] = true;
        q.offer(new Node(s, 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.idx == e){
                System.out.println(node.value);
                return;
            }

            for(int next : arr[node.idx]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new Node(next, node.value + 1));
                }
            }
        }
        System.out.println(-1);
    }
}
