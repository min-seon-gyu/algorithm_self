package 다익스트라;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_18352 {
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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] arr = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(new Node(e, 1));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((pq1, pq2) -> pq1.cost - pq2.cost);
        pq.offer(new Node(X, 0));
        int[] d = new int[N+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[X] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.cost != d[node.idx]) continue;
            for(Node n : arr[node.idx]){
                if(d[n.idx] > node.cost + n.cost){
                    pq.offer(new Node(n.idx, n.cost + node.cost));
                    d[n.idx] = node.cost + n.cost;
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        boolean check = false;
        for(int i = 1 ; i <= N ; i++){
            if(d[i] == K){
                check = true;
                sb.append(i).append("\n");
            }
        }

        if(check){
            System.out.println(sb);
        }else{
            System.out.println(-1);
        }
    }
}
