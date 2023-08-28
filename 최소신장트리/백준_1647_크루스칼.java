package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1647_크루스칼 {

    public static class Node implements Comparable<Node>{
        int idx1, idx2, cost;

        public Node(int idx1, int idx2, int cost) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n){
            return this.cost - n.cost;
        }

    }
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(parent, -1);

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Node(v1,v2,cost));
        }

        int answer = 0;
        int max = 0;
        int count = 0;
        int size = pq.size();

        for(int i = 0 ; i < size ; i++){
            Node node = pq.poll();
            if(union(node.idx1, node.idx2)){
                answer += node.cost;
                max = Math.max(max, node.cost);
                count++;
            }

            if(count == N - 1){
                break;
            }
        }
        System.out.println(answer - max);
    }

    public static boolean union(int v1, int v2){
        v1 = find(v1);
        v2 = find(v2);

        if(v1 == v2) return false;

        if(parent[v1] < parent[v2]){
            parent[v1] += parent[v2];
            parent[v2] = v1;
        }else{
            parent[v2] += parent[v1];
            parent[v1] = v2;
        }

        return true;
    }

    public static int find(int v){
        if(parent[v] < 0){
            return v;
        }

        return parent[v] = find(parent[v]);
    }
}
