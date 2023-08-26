package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1197_프림 {

    public static class Node{
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[V+1];
        ArrayList<Node>[] arr = new ArrayList[V+1];

        for(int i = 1 ; i <= V ; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr[v1].add(new Node(v2, value));
            arr[v2].add(new Node(v1, value));
        }

        PriorityQueue<Node> q = new PriorityQueue<>((p1, p2) -> p1.value - p2.value);
        q.offer(new Node(1, 0));

        int answer = 0;

        while(!q.isEmpty()){
            Node node = q.poll();
            if(check[node.idx]) continue;
            else check[node.idx] = true;

            answer += node.value;
            for(Node value : arr[node.idx]){
                if(!check[value.idx]){
                    q.offer(value);
                }
            }
        }
        System.out.println(answer);
    }
}
