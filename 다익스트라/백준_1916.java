package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1916 {
    public static class Node{
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        int[] arr = new int[V+1];
        ArrayList<Node>[] lst = new ArrayList[V+1];

        for(int i = 1 ; i<= V ; i++){
            lst[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            lst[v1].add(new Node(v2, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((pq1, pq2) -> pq1.cost - pq2.cost);
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.cost == arr[node.idx]){
                for(Node n : lst[node.idx]){
                    if(arr[n.idx] > n.cost + arr[node.idx]){
                        arr[n.idx] = n.cost + arr[node.idx];
                        pq.offer(new Node(n.idx, arr[n.idx]));
                    }
                }
            }
        }

        System.out.println(arr[end]);

    }
}
