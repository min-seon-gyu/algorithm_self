package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1647_프림 {

    public static class Node implements Comparable<Node>{
        int idx, cost;
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[N+1];
        ArrayList<Node>[] arr = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i ++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[v1].add(new Node(v2, cost));
            arr[v2].add(new Node(v1, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        int count = 0;
        int answer = 0;
        int max = 0;

        while(!pq.isEmpty()){

            Node node = pq.poll();

            if(check[node.idx]) continue;

            count++;
            answer += node.cost;
            max = Math.max(max, node.cost);
            check[node.idx] = true;

            for(Node n : arr[node.idx]){
                if(!check[n.idx]){
                    pq.offer(n);
                }
            }

        }
        System.out.println(answer-max);
    }
}
