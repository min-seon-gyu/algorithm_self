package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1753 {
    public static class Node{
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        ArrayList<Node>[] lst = new ArrayList[V+1];

        for(int i = 1 ; i <= V ; i++){
            lst[i] = new ArrayList<>();
        }

        for(int i = 0; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            lst[v1].add(new Node(v2, cost));
        }

        int[] answer = new int[V+1];
        int[] pre = new int[V+1];

        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[K] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>((q1, q2) -> q1.cost - q2.cost);
        q.offer(new Node(K , 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            int cost = node.cost;
            int idx = node.idx;

            if(cost == answer[idx]) {
                for (Node n : lst[idx]) {
                    if(answer[n.idx] > n.cost + answer[idx]){
                        pre[n.idx] = idx;
                        answer[n.idx] = n.cost + answer[idx];
                        q.offer(new Node(n.idx, cost + n.cost));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i<= V ; i++){
            if(answer[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }else{
                sb.append(answer[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
